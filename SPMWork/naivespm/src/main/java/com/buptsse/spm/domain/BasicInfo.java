package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "basicinfo")
public class BasicInfo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idcourseinfo", nullable = false)
    private int idCourseInfo;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "content", length = 10000)
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
