package ynu.edu.controller;

import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable("userId") Integer userId){
        CommonResult<User> result =new CommonResult<>();
        Integer code = 200;
        String message ="success(11000)";
        try {
            User u = new User(userId,"小明","10101");

            result.setResult(u);
        }catch (Exception e){
            e.printStackTrace();
            code=500;
            message="fail";
        }
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
