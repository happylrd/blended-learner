package com.buptsse.spm.domain;

import java.io.Serializable;

public class BasicInfo implements Serializable {

    private int idCourseInfo;
    private String name;
    private String content;

    public int getIdCourseInfo() {
        return idCourseInfo;
    }

    public void setIdCourseInfo(int idCourseInfo) {
        this.idCourseInfo = idCourseInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
