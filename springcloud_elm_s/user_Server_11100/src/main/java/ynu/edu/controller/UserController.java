package ynu.edu.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.domin.CommonResult;
import ynu.edu.domin.DeliveryAddress;
import ynu.edu.feign.DaService;
import ynu.edu.service.IUserService;
import ynu.edu.domin.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/UserController")
@CrossOrigin()
@RefreshScope

public class UserController {
    @Value("${msg_v}")//读取配置文件的msg_v
    private String msg_v;
    @Resource
    private IUserService userService;
    @GetMapping("/getUserByIdAndPassword")
    public User getUserByIdByPass(@RequestParam("userId") String userId,@RequestParam("password")String password) throws Exception{
        return userService.getUserByIdAndPassword(userId,password);
    }
    @GetMapping("/getMsg_v")
    public String getUserByIdByPass() throws Exception{
        return msg_v;
    }
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam("userId")String userId) throws Exception{
        return userService.getUserById(userId);
    }
    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user) throws Exception{
        return userService.saveUser(user);
    }

    @PostMapping("/updateUser")
    public int updateUser( User user)throws  Exception{
       return userService.updateUser(user);
    }
//调用da服务
    @Resource
    private DaService daService;
    @GetMapping("/listDeliveryAddressByUserId")
    @RateLimiter(name="rate1",fallbackMethod = "getDaDown")
    public List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId) throws Exception{
        return daService.listDeliveryAddressByUserId(userId);
    }

     public static List<DeliveryAddress> getDaDown(String userId,Throwable e)
    {
        e.printStackTrace();
        System.out.println("getDa服务被限流 用户id:"+userId);
        List<DeliveryAddress> daList= new ArrayList<>();
        return daList;
    }

    @GetMapping("/getOneAddressByUserId")
    public DeliveryAddress getOneAddressByUserId(@RequestParam("userId") String userId) throws Exception{
        return daService.getOneAddressByUserId(userId);
    }
    @GetMapping("/getDeliveryAddressById")
    @RateLimiter(name="rate1",fallbackMethod = "getDaDown2")
    public DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId) throws Exception{
        return daService.getDeliveryAddressById(daId);
    }
    public DeliveryAddress getDaDown2(Integer daId, Throwable e)
    {
        e.printStackTrace();
        System.out.println("getDa服务被限流 Daid:"+daId);
        CommonResult result= new CommonResult(400,"限流",null);
        DeliveryAddress da = new DeliveryAddress();
        return da;
    }
    @PostMapping("/saveDeliveryAddress")
    @RateLimiter(name="rate1",fallbackMethod = "postDaDown")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        System.out.println(deliveryAddress.toString());
        return daService.saveDeliveryAddress(deliveryAddress);
    }

    @CircuitBreaker(name="backendA",fallbackMethod = "postDaDown2")
    @PostMapping("/updateDeliveryAddress")
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        System.out.println(deliveryAddress.toString());
        return daService.updateDeliveryAddress(deliveryAddress);
    }
    @PostMapping("/removeDeliveryAddress")
    public int removeDeliveryAddress(@RequestParam("daId") Integer daId) throws Exception{
        return daService.removeDeliveryAddress(daId);
    }

    public int postDaDown(DeliveryAddress deliveryAddress, Throwable e)
    {
        e.printStackTrace();
        System.out.println("postDa服务被限流 Daid:"+deliveryAddress.getDaId());
        CommonResult result= new CommonResult(400,"限流",null);
        return 0;
    }
    public int postDaDown2(DeliveryAddress deliveryAddress, Throwable e)
    {
        e.printStackTrace();
        System.out.println("postDa服务被熔断 Daid:"+deliveryAddress.getDaId());
        CommonResult result= new CommonResult(400,"熔断",null);
        return 0;
    }
}
