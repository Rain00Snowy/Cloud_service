package ynu.edu.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
import ynu.edu.feign.ServiceProviderService;

import java.sql.SQLDataException;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private ServiceProviderService serviceProviderService;

    @GetMapping("/getCartById/{userId}")
//    @CircuitBreaker(name="backendA",fallbackMethod = "getCartByIdDown")
    @Bulkhead(name="bulkhead1",type = Bulkhead.Type.THREADPOOL,fallbackMethod = "getCartByIdDown2")

    public CommonResult getCartById(@PathVariable("userId") Integer userId) {
        CommonResult result = new CommonResult<>(200,"1",serviceProviderService.getUserById(userId));
        return result;
    }

    @PostMapping("/saveCart")
//    @CircuitBreaker(name="backendB",fallbackMethod = "saveCartDown")
    @RateLimiter(name="rate1",fallbackMethod = "saveCartDown2")

    public CommonResult saveCart(@RequestBody User user) {
        CommonResult result = new CommonResult<>(200,serviceProviderService.saveUser(user).toString(),null);
        return result;
    }
    // 删除方法
    @DeleteMapping("/deleteCartById/{userId}")
    public CommonResult deleteCartById(@PathVariable("userId") Integer userId) {
        CommonResult result = new CommonResult<>(200,serviceProviderService.deleteUserById(userId).toString(),null);
        return result;
    }

    // 更新方法
    @PutMapping("/updateCart")
    public CommonResult updateCart(@RequestBody User user) {
        CommonResult result = new CommonResult<>(200,serviceProviderService.updateUser(user).toString(),null);
        return result;
    }

    public CommonResult<User> getCartByIdDown(Integer userId, Throwable e)
    {
        e.printStackTrace();
        System.out.println("getCartById服务被熔断 用户id:"+userId);
        CommonResult<User> result= new CommonResult<>(400,"熔断",null);
        return result;
    }
    public CommonResult<User> saveCartDown(User user, Throwable e)
    {
        e.printStackTrace();
        System.out.println("saveCart服务被熔断 用户id:"+user.getUserId());
        CommonResult<User> result= new CommonResult<>(400,"熔断",null);
        return result;
    }
    public CommonResult<User> getCartByIdDown2(Integer userId, Throwable e)
    {
        e.printStackTrace();
        System.out.println("getCartById服务被隔离 用户id:"+userId);
        CommonResult<User> result= new CommonResult<>(400,"隔离",null);
        return result;
    }
    public CommonResult<User> saveCartDown2(User user, Throwable e)
    {
        e.printStackTrace();
        System.out.println("saveCart服务被限流 用户id:"+user.getUserId());
        CommonResult<User> result= new CommonResult<>(400,"限流",null);
        return result;
    }
}
