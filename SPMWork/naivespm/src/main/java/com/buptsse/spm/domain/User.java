package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 15)
    private String id;

    @Column(name = "userName", nullable = false, length = 45)
    private String userName;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    private String password1;

    @Column(name = "position", length = 45)
    private String position;

    @Column(name = "userId", length = 45)
    private String userId;

    @Column(name = "videoTime")
    private int videoTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(int videoTime) {
        this.videoTime = videoTime;
    }
}
