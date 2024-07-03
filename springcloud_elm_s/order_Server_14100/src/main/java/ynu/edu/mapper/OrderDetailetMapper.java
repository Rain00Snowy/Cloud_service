package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ynu.edu.domin.OrderDetailet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface OrderDetailetMapper extends BaseMapper<OrderDetailet> {
//    @Select("select * from orderdetailet where orderId=#{orderId} order by odId")
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId);
}
