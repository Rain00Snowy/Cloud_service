package ynu.edu.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.entity.User;
import ynu.edu.mapper.UserMapper;

@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByIdAndPassword(int userId, String password) {
        return userMapper.getUserByIdAndPassword(userId, password);
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }


    @Override
    public int updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteById(userId);
    }


}
