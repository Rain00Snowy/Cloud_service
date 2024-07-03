package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ynu.edu.domin.DeliveryAddress;

import java.util.List;

@Mapper
@Repository

public interface DeliveryAddressMapper extends BaseMapper<DeliveryAddress> {
    @Select("select * from deliveryAddress where userId=#{userId} order by daId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    @Select("select * from deliveryAddress where userId=#{userId} order by daId limit 1")
    public DeliveryAddress getOneAddressByUserId(String userId);

}
