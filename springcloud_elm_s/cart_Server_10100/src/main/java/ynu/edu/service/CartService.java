package ynu.edu.service;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;
import ynu.edu.domin.Cart;
import ynu.edu.mapper.CartMapper;

import java.util.List;
@Service

public class CartService implements ICartService {
    @Resource
    private CartMapper cartMapper;
    @Override
    public List<Cart> listCart(String userId, Integer businessId) {
        return cartMapper.listCart(userId,businessId);
    }
    @Override
    public int saveCart(Cart cart) {
        return cartMapper.insert(cart);
    }
    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }
    @Override
    public int removeCartByDetail(String userId, Integer businessId,Integer foodId) {
        return cartMapper.removeCartByDetail(userId,businessId,foodId);
    }
    @Override
    public int removeCart(int cartId) {
        return cartMapper.deleteById(cartId);
    }
}
