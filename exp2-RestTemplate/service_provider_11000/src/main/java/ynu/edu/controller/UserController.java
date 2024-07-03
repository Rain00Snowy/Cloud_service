package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;
import ynu.edu.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;
    @GetMapping("/getUserByIdAndPassword")
    public User getUserByIdByPass(Integer userId,String password) throws Exception{
        return userService.getUserByIdAndPassword(userId,password);
    }
    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable("userId")Integer userId) throws Exception{
        return userService.getUserById(userId);
    }
    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user) throws Exception{
        return userService.saveUser(user);
    }

    @PutMapping("/updateUser")
    public int updateUser(@RequestBody User user)throws  Exception{
        return userService.updateUser(user);
    }
    @DeleteMapping("/deleteUserById/{userId}")
    public int deleteUserById(@PathVariable("userId") Integer userId)throws  Exception{
        return userService.deleteUser(userId);
    }
//    @GetMapping("/getUserById2/{userId}")
//    public CommonResult<User> getUserById(@PathVariable("userId") Integer userId){
//        CommonResult<User> result =new CommonResult<>();
//        Integer code = 200;
//        String message ="success(11000)";
//        try {
//            User u = new User(userId,"小明","10101");
//
//            result.setResult(u);
//        }catch (Exception e){
//            e.printStackTrace();
//            code=500;
//            message="fail";
//        }
//        result.setCode(code);
//        result.setMessage(message);
//        return result;
//    }

}
