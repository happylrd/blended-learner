package com.buptsse.spm.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exam")
@IdClass(ExamPK.class)
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "examName", nullable = false, length = 50)
    private String examName;

    @Id
    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "question", nullable = false, length = 500)
    private String question;

    @Column(name = "answerA", length = 100)
    private String answerA;

    @Column(name = "answerB", length = 100)
    private String answerB;

    @Column(name = "answerC", length = 100)
    private String answerC;

    @Column(name = "answerD", length = 100)
    private String answerD;

    @Column(name = "answerRight", length = 2)
    private String answerRight;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(String answerRight) {
        this.answerRight = answerRight;
    }
}
