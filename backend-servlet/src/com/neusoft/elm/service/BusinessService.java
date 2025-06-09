package com.neusoft.elm.service;
import java.util.List;
import com.neusoft.elm.po.Business;
public interface BusinessService {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

    public Business getBusinessById(Integer businessId);
}