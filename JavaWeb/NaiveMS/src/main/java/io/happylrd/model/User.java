package io.happylrd.model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    private String cellphoneNumber;
    private String name;
    private String sex;
    private int age;
    private boolean isAvailable = true;

    private String nextUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    @Override
    public String toString() {
        return "User{username='" + username +
                "', password='" + password +
                "', cellphoneNumber='" + cellphoneNumber +
                "', name='" + name +
                "', sex='" + sex +
                "', age=" + age +
                "', isAvailable=" + isAvailable + "}";
    }
}
