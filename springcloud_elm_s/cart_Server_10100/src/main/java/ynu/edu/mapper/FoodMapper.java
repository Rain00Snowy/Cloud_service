package ynu.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;
import ynu.edu.domin.Food;

import java.util.List;

@Mapper
@Repository

public interface FoodMapper extends BaseMapper<Food> {
    @Select("select * from food where businessId=#{businessId} order by foodId")
    public List<Food> listFoodByBusinessId(Integer businessId);
}
