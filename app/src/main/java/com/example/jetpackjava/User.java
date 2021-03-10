package com.example.jetpackjava;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String adss;
    String phoneNum;
    int age;

    public User(String name, String adss, String phoneNum, int age) {
        this.name = name;
        this.adss = adss;
        this.phoneNum = phoneNum;
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdss() {
        return adss;
    }

    public void setAdss(String adss) {
        this.adss = adss;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", adss='" + adss + '\'' +
                ", age=" + age +
                '}';
    }
}
