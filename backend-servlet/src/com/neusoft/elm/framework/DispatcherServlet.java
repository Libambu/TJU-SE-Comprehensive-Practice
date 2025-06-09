package com.neusoft.elm.framework;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
/**
 * 自定义前端控制器 拦截url格式要求： /控制器类名/控制器方法名
 * 分发请求
 */
@WebServlet(name = "mydemo", value = "/")
public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
//中文编码处理
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
//获取客户端请求路径(/HelloController/say)
        String path = request.getServletPath();
//根据请求路径，将Controller的类名和方法名解析出来
        String className = path.substring(1,path.lastIndexOf("/"));
        String methodName = path.substring(path.lastIndexOf("/")+1);
        PrintWriter out = null;
//判断请求路径，根据不同的请求，分发给不同的业务处理器
        try{
//通过Controller类全名获取此类的所有信息
            Class clazz = Class.forName("com.neusoft.elm.controller."+className);
//创建Controller类的对象
            Object controller = clazz.newInstance();
//获取Controller类对象中的方法
            Method method = clazz.getMethod(methodName,new Class[]{HttpServletRequest.class});
//调用上面获取的方法
            Object result = method.invoke(controller,new Object[]{request});
//获取向客户端响应的输出流
            out = response.getWriter();
            ObjectMapper om = new ObjectMapper();
//向客户端响应json数据
            out.print(om.writeValueAsString(result));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("DispatcherServlet信息：请求url："+path);
            System.out.println("DispatcherServlet信息：类名："+className+"\t方法名："+methodName);
        }finally {
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request,response);
    }
}