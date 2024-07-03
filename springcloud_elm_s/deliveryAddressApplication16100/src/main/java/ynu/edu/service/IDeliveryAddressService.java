package ynu.edu.service;

import ynu.edu.domin.DeliveryAddress;

import java.util.List;

public interface IDeliveryAddressService {
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    public DeliveryAddress getDeliveryAddressById(Integer daId);
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);
    public int removeDeliveryAddress(Integer daId);
    public DeliveryAddress getOneAddressByUserId(String userId);
}
