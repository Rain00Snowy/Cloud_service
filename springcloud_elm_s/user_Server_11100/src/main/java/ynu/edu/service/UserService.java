package ynu.edu.service;

import jakarta.annotation.Resource;

import ynu.edu.domin.User;

import org.springframework.stereotype.Service;
import ynu.edu.mapper.UserMapper;

@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByIdAndPassword(String userId, String password) {
        return userMapper.getUserByIdAndPassword(userId, password);
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public String selectImg(Integer userId) {
        return userMapper.selectImg(userId);
    }

    ;

    @Override
    public int updateImg(Integer userId, String userImg) {
        return userMapper.updateImg(userId, userImg);
    }

    ;

    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }


}
