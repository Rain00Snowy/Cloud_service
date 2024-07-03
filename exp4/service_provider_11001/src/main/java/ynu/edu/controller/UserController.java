package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
//import ynu.edu.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
            User u = new User(userId,"小明(11001)","10101");
        System.out.println(u.getUserId());
        return u;
    }
}
