package com.neusoft.elm.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.neusoft.elm.po.Cart;
import com.neusoft.elm.service.CartService;
import com.neusoft.elm.service.impl.CartServiceImpl;
public class CartController {
    public Object saveCart(HttpServletRequest request) throws Exception{
        Cart cart = new Cart();
        cart.setFoodId(Integer.valueOf(request.getParameter("foodId")));
        cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        cart.setUserId(request.getParameter("userId"));
        CartService service = new CartServiceImpl();
        int result = service.saveCart(cart);
        return result;
    }
    public Object updateCart(HttpServletRequest request) throws Exception{
        Cart cart = new Cart();
        cart.setFoodId(Integer.valueOf(request.getParameter("foodId")));
        cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        cart.setUserId(request.getParameter("userId"));
        cart.setQuantity(Integer.valueOf(request.getParameter("quantity")));
        CartService service = new CartServiceImpl();
        int result = service.updateCart(cart);
        return result;
    }
    public Object removeCart(HttpServletRequest request) throws Exception{
        Cart cart = new Cart();
        cart.setFoodId(Integer.valueOf(request.getParameter("foodId")));
        cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        cart.setUserId(request.getParameter("userId"));
        CartService service = new CartServiceImpl();
        int result = service.removeCart(cart);
        return result;
    }
    public Object listCart(HttpServletRequest request) throws Exception{
        Cart cart = new Cart();
        cart.setUserId(request.getParameter("userId"));
        if(request.getParameter("businessId")!=null) {
            cart.setBusinessId(Integer.valueOf(request.getParameter("businessId")));
        }
        CartService service = new CartServiceImpl();
        List<Cart> list = service.listCart(cart);
        return list;
    }
}