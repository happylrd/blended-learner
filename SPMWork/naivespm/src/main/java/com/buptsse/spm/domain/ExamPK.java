package com.buptsse.spm.domain;

import java.io.Serializable;

public class ExamPK implements Serializable {

    private String examName;

    private int number;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamPK examPK = (ExamPK) o;

        return number == examPK.number && (examName != null
                ? examName.equals(examPK.examName) : examPK.examName == null);
    }

    @Override
    public int hashCode() {
        int result = examName != null ? examName.hashCode() : 0;
        result = 31 * result + number;
        return result;
    }
}
