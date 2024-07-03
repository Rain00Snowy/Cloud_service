package ynu.edu.service;

import ynu.edu.domin.Business;

import java.util.List;

public interface IBusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);
    public Business getBusinessById(Integer businessId);
}
