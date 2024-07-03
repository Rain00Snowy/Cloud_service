package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import ynu.edu.domin.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface OrdersMapper extends BaseMapper<Orders> {
//    @Select("select * from orders where userId=#{userId} order by ordersId")
    public List<Orders> listOrdersByUserId(String userId);
    public Orders getOrdersById(Integer orderId);
    @Update("update orders set orderState = 1 where orderId = #{orderId}")
    public int payOrders(Integer orderId);
}
