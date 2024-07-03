package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
//    @Resource
//    private DiscoveryClient discoveryClient;


    @GetMapping("/getCartById/{userId}")
    public CommonResult getCartById(@PathVariable("userId") Integer userId){
//        提供服务提供者的name获取eureka server的服务注册列表
//        List<ServiceInstance> instanceList =discoveryClient.getInstances("provider-server");
//        for (ServiceInstance si:instanceList) {
//            System.out.println(si.getHost()+"\t"+si.getPort());
//        }
//        ServiceInstance instance = instanceList.get(0);

        CommonResult result = restTemplate.getForObject(
                "http://provider-server/user/getUserById/"+userId.toString(),
                CommonResult.class);
        return result;
    }
}
