package com.neusoft.elm.po;

public class OrderDetailet {
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
    //多对一：所属食品
    private Food food;

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "OrderDetailet{" +
                "odId=" + odId +
                ", orderId=" + orderId +
                ", foodId=" + foodId +
                ", quantity=" + quantity +
                ", food=" + food +
                '}';
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }
}
