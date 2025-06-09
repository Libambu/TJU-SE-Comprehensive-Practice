package com.neusoft.elm.dao;

import com.neusoft.elm.po.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws Exception;
    public Business getBusinessById(Integer businessId) throws Exception;
}
