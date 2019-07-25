package cn.cast.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.ObjectExpression;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangben
 * @create 2019-07-25 17:15
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取这个用户名
        String username = request.getParameter("username");

        //期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"
        //------------------------：{"userExsit":false,"msg":"用户名可用"
        response.setContentType("application/json;charset=utf-8");//在tomcat-conf-web.xml中搜索json看是什么格式的
        Map<String,Object> map = new HashMap<String, Object>();//泛型后面的可以补全

        //2.查询数据库（调用service层，（service再去dao查询数据库））
        String s ="tom";
        if(s.equals(username)){
            //假设是tom，我们认为存在
            map.put("userExsit",true);
            map.put("msg","此用户名太受欢迎,请更换一个");
        }else{
            //不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }
        //将map转为json，并且写到页面上（并且串送给客户端）
        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(mapper);//再用response的输出流将字符串输出出去
        //将数据传送给客户端
        mapper.writeValue(response.getWriter(),map);//把map再传进去就可以了
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
