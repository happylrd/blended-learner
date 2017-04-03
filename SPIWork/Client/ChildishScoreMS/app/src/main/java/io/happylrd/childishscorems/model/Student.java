package io.happylrd.childishscorems.model;

import com.google.gson.annotations.SerializedName;

/**
 * url: http://localhost:8000/users/students/2014210005/
 * json: {
 * "id": 5,
 * "username": "2014210005",
 * "password": "123456",
 * "realname": "蓉儿",
 * "mobile": "13500005555",
 * "school": "桃花岛学院",
 * "major": "古典文学",
 * "gender": "female",
 * "birthday": "1999-07-07",
 * "permission_type": 0,
 * "add_time": "2017-04-03T19:46:00"
 * }
 */
public class Student {

    private Integer id;

    private String username;
    private String password;
    private String realname;
    private String mobile;
    private String school;
    private String major;
    private String gender;
    private String birthday;

    @SerializedName("permission_type")
    private Integer permissionType;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
