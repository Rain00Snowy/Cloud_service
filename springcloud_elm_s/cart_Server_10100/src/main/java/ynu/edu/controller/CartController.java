package ynu.edu.controller;

import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import ynu.edu.domin.Cart;
import ynu.edu.service.ICartService;

import java.util.List;

//@Api(tags = "Cart相关接口")
@RestController
@RequestMapping("/CartController")
@CrossOrigin()
@RefreshScope

public class CartController {
    @Resource
    private ICartService cartService;
//    @ApiOperation(value = "查找Cart集合",notes = "查找跟传入Cart相同的用户id，商家id的所有Cart项")
    @PostMapping("/listCart")
    public List<Cart> listCart(@RequestParam(name="userId") String userId,
                               @RequestParam(name="businessId" ,required = false) Integer businessId) throws Exception{
        return cartService.listCart( userId, businessId);
    }

    @PostMapping("/saveCart")
    public int saveCart(Cart cart) throws Exception{
        return cartService.saveCart(cart);
    }
//    @ApiOperation(value = "更新Cart")
    @PostMapping("/updateCart")
    public int updateCart(Cart cart) throws Exception{
        return cartService.updateCart(cart);
    }
//    @ApiOperation(value = "删除CartById")
    @PostMapping("/removeCart")
    public int removeCart(@RequestParam(name="cartId")Integer cartId) throws Exception{
        return cartService.removeCart(cartId);
    }
    @PostMapping("/removeCartByDetail")
    public int removeCartByDetail(@RequestParam("userId") String userId,@RequestParam("businessId") Integer businessId,@RequestParam(value = "foodId" ,required = false) Integer foodId) throws Exception{
        return cartService.removeCartByDetail(userId,businessId,foodId);
    }
}
