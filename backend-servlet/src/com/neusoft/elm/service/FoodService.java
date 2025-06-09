package com.neusoft.elm.service;
import java.util.List;
import com.neusoft.elm.po.Food;
public interface FoodService {
    public List<Food> listFoodByBusinessId(Integer businessId);
}