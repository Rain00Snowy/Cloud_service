package ynu.edu.service;

import jakarta.annotation.Resource;
import ynu.edu.mapper.BusinessMapper;
import ynu.edu.domin.Business;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BusinessService implements IBusinessService {
    @Resource
    private BusinessMapper businessMapper;
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        return businessMapper.listBusinessByOrderTypeId(orderTypeId);
    }
    @Override
    public Business getBusinessById(Integer businessId) {
        return businessMapper.selectById(businessId);
    }
}
