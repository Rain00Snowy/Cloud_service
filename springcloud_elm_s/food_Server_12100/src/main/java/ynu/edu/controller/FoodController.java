package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.service.FoodService;
import ynu.edu.domin.Food;

import java.util.List;

@RestController
@RequestMapping("/FoodController")
@CrossOrigin(allowedHeaders = {"*"})
@RefreshScope

public class FoodController {
    @Resource
    private FoodService foodService;
    @GetMapping("/listFoodByBusinessId")
    public List<Food> listFoodByBusinessId(@RequestParam("businessId") Integer businessId) throws Exception{
        return foodService.listFoodByBusinessId(businessId);
    }
}
