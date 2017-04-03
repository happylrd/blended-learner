package io.happylrd.childishscorems.model;

import com.google.gson.annotations.SerializedName;

/**
 * url: http://localhost:8000/users/teachers/1014210001/
 * json: {
 * "id": 1,
 * "username": "1014210001",
 * "password": "123456",
 * "realname": "黄老邪",
 * "mobile": "15600001111",
 * "school": "桃花岛学院",
 * "gender": "male",
 * "birthday": "1983-07-07",
 * "add_time": "2017-04-03T21:11:00"
 * }
 */
public class Teacher {
    private Integer id;

    private String username;
    private String password;
    private String realname;
    private String mobile;
    private String school;
    private String gender;
    private String birthday;

    @SerializedName("add_time")
    private String addTime;

    public Integer getId() {
        return id;
    }

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
