package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ynu.edu.entity.User;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where userId=#{userId} and password=#{password}")
    public User getUserByIdAndPassword(@Param("id")int userId, @Param("password")String password);

}
