package cn.cast.test;


import cn.cast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author zhangben
 * @create 2019-07-25 12:37
 */
public class Jackson {

    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
            //1.创建Peroson对象
            Person p = new Person();
            p.setName("张三");
            p.setAge(23);
            p.setGender("男");

            //2.创建jackson的核心对象  ObejctMapper
            ObjectMapper mapper = new ObjectMapper();
            //3.调用方法转换
            /*
                转换方法：
                writeValue(参数1,obj)
                    参数1：
                        File：将obj对象转化为JSON字符串，并保存到指定的文件中
                        Writer:将obj对象转为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream:将obj转为JSON字符串，并将json数据填充到字节流中
                writeValueAsString(obj);将这个obj对象转化成json字符串
             */
        String json = mapper.writeValueAsString(p);
        //期望生成的是json的格式 例如：{"name":"张三"，"age":23,"gender":"男"}
          System.out.println(json);//成功了，{"name":"张三","age":23,"gender":"男"}

        //writeValue:将数据写到d://a.txt
//        mapper.writeValue(new File("d://aa.txt"),p);//在盘放的就㐊p的json格式的数据

        //writeValue.将数据关联到Write里面
        mapper.writeValue(new FileWriter("d:/abcd.txt"),p);
    }
    @Test
    public void test2() throws Exception {
            //1.创建Peroson对象
            Person p = new Person();
            p.setName("张三");
            p.setAge(23);
            p.setGender("男");
            p.setBirthday(new Date());

            //2.创建jackson核心对象   ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            //3：调用方法
            String json = mapper.writeValueAsString(p);
            System.out.println(json);//{"name":"张三","age":23,"gender":"男","birthday":"2019-07-25 05:41:21"}

    }    @Test
    public void test3() throws Exception {
        //1.创建Peroson对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());


        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("张三");
        p3.setAge(23);
        p2.setGender("男");
        p3.setBirthday(new Date());

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);



        //2创建jackson方法    ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //调用方法
        String json = mapper.writeValueAsString(list);//[{"name":"张三","age":23,"gender":"男","birthday":"2019-07-25 08:23:16"},{"name":"张三","age":23,"gender":"男","birthday":"2019-07-25 08:23:16"},{"name":"张三","age":23,"gender":null,"birthday":"2019-07-25 08:23:16"}]

        System.out.println(json);
    }
    @Test
    public void test4() throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");

        //2创建jackson方法    ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //调用方法
        String json = mapper.writeValueAsString(map);//{"gender":"男","name":"张三","age":23}


        System.out.println(json);
    }
    //演示json字符串转为Java对象和java转为Json是一样的不过是调了一个别的方法，json转java对象不常用
    @Test
    public void test5() throws IOException {
        //1:.初始化JSON字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";//粘贴过来一个json格式，会自动变成这样

        //创建jackson核心对象    ObjectMapper
        ObjectMapper  mapper = new ObjectMapper();
        //转换成Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);


    }
}
