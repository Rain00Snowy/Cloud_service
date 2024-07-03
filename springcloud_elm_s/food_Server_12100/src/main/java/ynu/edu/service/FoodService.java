package ynu.edu.service;

import jakarta.annotation.Resource;
import ynu.edu.domin.Food;
import org.springframework.stereotype.Service;
import ynu.edu.mapper.FoodMapper;

import java.util.List;
@Service
public class FoodService implements IFoodService {
    @Resource
    private FoodMapper foodMapper;
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        return foodMapper.listFoodByBusinessId(businessId);
    }
}
