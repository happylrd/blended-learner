package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "studentId", nullable = false, length = 15)
    private String studentId = "";

    @Column(name = "name", nullable = false, length = 45)
    private String name = "";

    @Column(name = "classId", nullable = false, length = 45)
    private String classId = "";

    @Column(name = "email", nullable = false, length = 45)
    private String email = "";

    @Column(name = "telno", nullable = false, length = 20)
    private String telno = "";

    @Column(name = "status", nullable = false, length = 45)
    private String status = "";

    @Column(name = "dailyGrade", precision = 2)
    private BigDecimal dailyGrade = new BigDecimal(0.00);

    @Column(name = "midGrade", precision = 2)
    private BigDecimal midGrade = new BigDecimal(0.00);

    @Column(name = "finalGrade", precision = 2)
    private BigDecimal finalGrade = new BigDecimal(0.00);

    @Column(name = "practiceGrade", precision = 2)
    private BigDecimal practiceGrade = new BigDecimal(0.00);

    @Column(name = "totalGrade", precision = 2)
    private BigDecimal totalGrade = new BigDecimal(0.00);

    @Column(name = "syear", length = 4)
    private String syear;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDailyGrade() {
        return dailyGrade;
    }

    public void setDailyGrade(BigDecimal dailyGrade) {
        this.dailyGrade = dailyGrade;
    }

    public BigDecimal getMidGrade() {
        return midGrade;
    }

    public void setMidGrade(BigDecimal midGrade) {
        this.midGrade = midGrade;
    }

    public BigDecimal getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(BigDecimal finalGrade) {
        this.finalGrade = finalGrade;
    }

    public BigDecimal getPracticeGrade() {
        return practiceGrade;
    }

    public void setPracticeGrade(BigDecimal practiceGrade) {
        this.practiceGrade = practiceGrade;
    }

    public BigDecimal getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(BigDecimal totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }
}
