package ynu.edu.service;


import ynu.edu.domin.Cart;

import java.util.List;

public interface ICartService {
    public List<Cart> listCart(String userId, Integer businessId);
    public int saveCart(Cart cart);
    public int updateCart(Cart cart);
    public int removeCart(int cartId);
    public int removeCartByDetail(String userId, Integer businessId,Integer foodId);
}
