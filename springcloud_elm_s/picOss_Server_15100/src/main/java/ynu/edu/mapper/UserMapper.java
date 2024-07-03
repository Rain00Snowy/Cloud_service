package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ynu.edu.domin.User;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where userId=#{userId} and password=#{password}")
    public User getUserByIdAndPassword(@Param("userId")String userId, @Param("password")String password);

    public String selectImg(@Param("userId")Integer userId);

    public int updateImg(@Param("userId") Integer userId,@Param("userImg") String userImg);
}
