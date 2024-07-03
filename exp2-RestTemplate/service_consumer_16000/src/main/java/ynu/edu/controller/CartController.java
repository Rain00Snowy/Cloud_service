package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

//    springboot提供的微服务直接调用的类
    @Resource
    private RestTemplate restTemplate;

//    用于寻找服务注册表
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/getCartById/{userId}")
    public CommonResult getCartById(@PathVariable("userId") Integer userId){
//        提供服务提供者的name获取eureka server的服务注册列表
        List<ServiceInstance> instanceList =discoveryClient.getInstances("provider-server");
        for (ServiceInstance si:instanceList) {
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        System.out.println("http://" + instance.getHost() + ":" + instance.getPort() + "/user/getUserById/" + userId.toString());
        CommonResult<User> result = new CommonResult<>(200,"1",
                restTemplate.getForObject(
                        "http://"+instance.getHost()+":"+instance.getPort()+"/user/getUserById/"+userId.toString(),
                User.class));
        return result;
    }
    // 删除方法
    @DeleteMapping("/deleteCartById/{userId}")
    public CommonResult deleteCartById(@PathVariable("userId") Integer userId) {
        // 获取服务实例列表
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for (ServiceInstance si:instanceList) {
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        // 调用服务端的删除端点
        restTemplate.delete("http://" + instance.getHost() + ":" + instance.getPort() + "/user/deleteUserById/" + userId.toString());

        // 返回成功消息或者在你的用例中适当的内容
        return new CommonResult(200,"成功",null);
    }

    // 更新方法
    @PutMapping("/updateCart")
    public CommonResult updateCart(@RequestBody User user) {
        List<ServiceInstance> instanceList =discoveryClient.getInstances("provider-server");
        for (ServiceInstance si:instanceList) {
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);
        restTemplate.put("http://" + instance.getHost() + ":" + instance.getPort() + "/user/updateUser" , user);
        return new CommonResult(200,"成功",null);

    }


    @PostMapping("/saveCart")
    public CommonResult saveCart(@RequestBody User user) {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider-server");
        for (ServiceInstance si:instanceList) {
            System.out.println(si.getHost()+"\t"+si.getPort());
        }
        ServiceInstance instance = instanceList.get(0);

        restTemplate.postForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/user/saveUser", user, Integer.class);
        // 返回成功消息或者在你的用例中适当的内容
        return new CommonResult(200,"成功", null);
    }

}
