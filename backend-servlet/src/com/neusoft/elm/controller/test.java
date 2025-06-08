package com.neusoft.elm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class test {
    public Object login(HttpServletRequest request) throws UnsupportedEncodingException {
        String username = request.getParameter("username");
        System.out.println(username);
        po p = new po(username,10);
        System.out.println(System.getProperty("file.encoding"));
        return p;
    }
}
