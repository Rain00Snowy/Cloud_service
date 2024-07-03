package ynu.edu.service;


import ynu.edu.domin.User;

public interface IUserService {
    public User getUserByIdAndPassword(String userId, String password);
    public User getUserById(String userId);
    public int saveUser(User user);

    public String selectImg(Integer userId);
    public int updateImg( Integer userId,String userImg);

    public int updateUser(User user);
}
