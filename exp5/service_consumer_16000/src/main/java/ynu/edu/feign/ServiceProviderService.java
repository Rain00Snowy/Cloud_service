package ynu.edu.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;

@FeignClient("provider-server")
public interface ServiceProviderService {
    @GetMapping("/user/getUserById/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId);

    @PostMapping("/user/saveUser")
    public Integer saveUser(@RequestBody User user);

    @PutMapping("/user/updateUser")
    public Integer updateUser(@RequestBody User user);

    @DeleteMapping("/user/deleteUserById/{userId}")
    public Integer deleteUserById(@PathVariable("userId")Integer userId);
}
