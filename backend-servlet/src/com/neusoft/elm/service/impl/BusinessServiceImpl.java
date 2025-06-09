package com.neusoft.elm.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.neusoft.elm.dao.BusinessDao;
import com.neusoft.elm.dao.Impl.BusinessDaoImpl;
import com.neusoft.elm.po.Business;
import com.neusoft.elm.service.BusinessService;
import com.neusoft.elm.util.DBUtil;

public class BusinessServiceImpl implements BusinessService{
    @Override
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        List<Business> list = new ArrayList<>();
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listBusinessByOrderTypeId(orderTypeId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
    @Override
    public Business getBusinessById(Integer businessId) {
        Business business = null;
        BusinessDao dao = new BusinessDaoImpl();
        try {
            DBUtil.getConnection();
            business = dao.getBusinessById(businessId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return business;
    }
}