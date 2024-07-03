package ynu.edu.service;

import ynu.edu.domin.Orders;

import java.util.List;

public interface IOrdersService {
    public int createOrders(Orders orders);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId);
    public int payOrders(Integer orderId);
}
