package ynu.edu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @RequestMapping("fallback")
    public String fallback(){
        System.out.println("服务熔断，稍后使用");
        return "服务熔断，稍后使用";
    }
    @RequestMapping("fallback2")
    public String fallback2(){

        return "服务限流，稍后使用";
    }

}
