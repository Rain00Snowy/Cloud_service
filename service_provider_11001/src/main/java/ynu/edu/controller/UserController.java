package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
//import ynu.edu.service.IUserService;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Value("${msg}")//读取配置文件的msg
    private String msg;

    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
            User u = new User(userId,"小明(11001)","10101,msg:"+msg);
        System.out.println(u.getUserId());
        System.out.println(msg);
        return u;
    }
}
