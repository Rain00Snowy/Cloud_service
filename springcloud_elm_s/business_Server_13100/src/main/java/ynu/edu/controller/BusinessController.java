package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.service.IBusinessService;
import ynu.edu.domin.Business;

import java.util.List;

//@Api(tags="Business相关接口")
@RestController
@RequestMapping("/BusinessController")
@CrossOrigin()

public class BusinessController {
    @Resource
    private IBusinessService businessService;

//    @ApiOperation(value = "通过订单类型查找商家")
    @GetMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam("orderTypeId") Integer orderTypeId) throws Exception{
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }

//    @ApiOperation(value = "通过businessId查找商家")
    @GetMapping("/getBusinessById")
    public Business getBusinessById(Business business) throws Exception{
        return businessService.getBusinessById(business.getBusinessId());
    }
}
