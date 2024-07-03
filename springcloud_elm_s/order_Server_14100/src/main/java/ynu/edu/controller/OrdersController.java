package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import ynu.edu.service.IOrdersService;
import ynu.edu.domin.Orders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
@CrossOrigin(allowedHeaders = {"*"})
@RefreshScope

public class OrdersController {
    @Resource
    private IOrdersService ordersService;
    @PostMapping("/createOrders")
    public int createOrders(Orders orders) throws Exception{
        return ordersService.createOrders(orders);
    }
    @GetMapping("/getOrdersById")
    public Orders getOrdersById(@RequestParam("orderId") Integer orderId) throws Exception{
        return ordersService.getOrdersById(orderId);
    }
    @GetMapping("/listOrdersByUserId")
    public List<Orders> listOrdersByUserId(@RequestParam("userId")String userId) throws Exception{
        return ordersService.listOrdersByUserId(userId);
    }
    @PostMapping("/payOrders")
    public int payOrders(@RequestParam("orderId")Integer orderId)throws Exception{
        System.out.println(orderId);
        return ordersService.payOrders(orderId);
    }
}
