package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ynu.edu.entity.CommonResult;
import ynu.edu.feign.ServiceProviderService;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Resource
    private ServiceProviderService serviceProviderService;

    @GetMapping("/getCartById/{userId}")
    public CommonResult getCartById(@PathVariable("userId") Integer userId) {

        CommonResult result = serviceProviderService.getUserById(userId);
        return result;
    }
}
