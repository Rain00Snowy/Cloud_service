package ynu.edu.service;

import jakarta.annotation.Resource;
import ynu.edu.mapper.CartMapper;
import ynu.edu.mapper.OrderDetailetMapper;
import ynu.edu.mapper.OrdersMapper;
import ynu.edu.domin.Cart;
import ynu.edu.domin.OrderDetailet;
import ynu.edu.domin.Orders;
import ynu.edu.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService implements IOrdersService {
    @Resource
    private CartMapper cartMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private OrderDetailetMapper orderDetailetMapper;
    @Override
    @Transactional
    public int createOrders(Orders orders) {
        Cart cart = new Cart();
        cart.setUserId(orders.getUserId());
        cart.setBusinessId(orders.getBusinessId());
        cart.setCartId(orders.getDaId());
        //查询当前用户购物车中当前商家的所有食品
        List<Cart> cartList = cartMapper.listCart(cart.getUserId(),cart.getBusinessId());
        //创建订单（返回生成的订单编号）
        orders.setOrderDate(DateUtil.getDate());//getDate获取当前日期的格式化字符串
        orders.setOrderTotal(orders.getOrderTotal());
        ordersMapper.insert(orders);
        //批量添加订单明细
        int orderId = orders.getOrderId();
        for(Cart c : cartList) {
            OrderDetailet od = new OrderDetailet();
            od.setOrderId(orderId);
            od.setFoodId(c.getFoodId());
            od.setQuantity(c.getQuantity());
            orderDetailetMapper.insert(od);
        }
        //从购物车表中删除相关食品信息
        cartMapper.removeCartByDetail(cart.getUserId(),cart.getBusinessId(),cart.getFoodId());
        return orderId;
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.getOrdersById(orderId);
    }
//    @Transactional
    @Override
    public List<Orders> listOrdersByUserId(String userId){
        return ordersMapper.listOrdersByUserId(userId);
    }
    @Override
    public int payOrders(Integer orderId){
        return ordersMapper.payOrders(orderId);
    }
}
