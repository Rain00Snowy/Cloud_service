package ynu.edu.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ynu.edu.domin.DeliveryAddress;
import ynu.edu.mapper.DeliveryAddressMapper;

import java.util.List;
@Service

public class DeliveryAddressService implements IDeliveryAddressService {
    @Resource
    private DeliveryAddressMapper deliveryAddressMapper;
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return deliveryAddressMapper.listDeliveryAddressByUserId(userId);
    }
    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressMapper.selectById(daId);
    }
    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.insert(deliveryAddress);
    }
    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return deliveryAddressMapper.updateById(deliveryAddress);
    }
    @Override
    public int removeDeliveryAddress(Integer daId) {
        return deliveryAddressMapper.deleteById(daId);
    }

    @Override
    public DeliveryAddress getOneAddressByUserId(String userId){
        return deliveryAddressMapper.getOneAddressByUserId(userId);
    };

}
