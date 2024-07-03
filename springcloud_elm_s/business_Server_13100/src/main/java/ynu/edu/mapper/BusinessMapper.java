package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.edu.domin.Business;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository

public interface BusinessMapper extends BaseMapper<Business> {
    @Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

}
