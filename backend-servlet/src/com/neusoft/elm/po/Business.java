package com.neusoft.elm.po;
public class Business {
    private Integer businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;
    private double starPrice; //起送费
    private double deliveryPrice; //配送费
    private String remarks;
//get、set ... ...

    public String getBusinessName() {
        return businessName;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessExplain='" + businessExplain + '\'' +
                ", businessImg='" + businessImg + '\'' +
                ", orderTypeId=" + orderTypeId +
                ", starPrice=" + starPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public void setStarPrice(double starPrice) {
        this.starPrice = starPrice;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public String getBusinessImg() {
        return businessImg;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public double getStarPrice() {
        return starPrice;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getRemarks() {
        return remarks;
    }
}