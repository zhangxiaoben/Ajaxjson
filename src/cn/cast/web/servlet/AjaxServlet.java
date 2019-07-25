package cn.cast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhangben
 * @create 2019-07-24 16:07
 */
@javax.servlet.annotation.WebServlet("/ajaxServlet")
public class AjaxServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.获取请求参数
        String username = request.getParameter("username");
        //处理业务逻辑，要耗时间    同步的
//        try {         //对应把jtrue改成false试试，同步需要等待不舒服              xmlhttp.open("GET","ajaxServlet?username=tom",true);
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //2.打印下username
        System.out.println(username);
        //3.响应
        response.getWriter().write("hello : " + username);

        //接收和处理服务器的响应结果


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
