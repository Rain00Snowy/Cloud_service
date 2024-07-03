package ynu.edu.service;


import ynu.edu.entity.User;

public interface IUserService {
    public User getUserByIdAndPassword(int userId, String password);
    public User getUserById(int userId);
    public int saveUser(User user);

    public int updateUser(User user);

    public int deleteUser(int userId);
}
