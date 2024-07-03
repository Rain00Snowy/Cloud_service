package ynu.edu.service;

import ynu.edu.domin.Food;

import java.util.List;

public interface IFoodService {
    public List<Food> listFoodByBusinessId(Integer businessId);
}
