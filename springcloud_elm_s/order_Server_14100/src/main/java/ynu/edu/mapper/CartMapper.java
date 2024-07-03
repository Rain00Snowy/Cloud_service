package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ynu.edu.domin.Cart;

import java.util.List;

@Mapper
@Repository

public interface CartMapper extends BaseMapper<Cart> {
    public List<Cart> listCart(@Param("userId") String userId, @Param("businessId") Integer businessId);

    public int removeCartByDetail(@Param("userId") String userId, @Param("businessId") Integer businessId,@Param("foodId") Integer foodId);

    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=#{businessId} and userId=#{userId}")
    public int updateCart(Cart cart);
}
