package cn.cast.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author zhangben
 * @create 2019-07-25 12:26
 */
public class Person {
    private  String name;
    private  int age;
    private String gender;
//    @JsonIgnore//忽略改属性
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date birthday;//日期默认的是毫秒值

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Gender='" + gender + '\'' +
                '}';
    }
}
