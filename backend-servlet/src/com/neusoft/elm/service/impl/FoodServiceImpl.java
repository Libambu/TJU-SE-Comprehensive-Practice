package com.neusoft.elm.service.impl;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.elm.dao.FoodDao;
import com.neusoft.elm.dao.Impl.FoodDaoImpl;
import com.neusoft.elm.po.Food;
import com.neusoft.elm.service.FoodService;
import com.neusoft.elm.util.DBUtil;
public class FoodServiceImpl implements FoodService{
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        List<Food> list = new ArrayList<>();
        FoodDao dao = new FoodDaoImpl();
        try {
            DBUtil.getConnection();
            list = dao.listFoodByBusinessId(businessId);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
}