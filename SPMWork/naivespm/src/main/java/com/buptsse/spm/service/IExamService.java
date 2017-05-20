package com.buptsse.spm.service;

import java.util.List;
import java.util.Map;

import com.buptsse.spm.domain.Exam;

public interface IExamService {

    boolean saveExam(Exam Exam);

    boolean removeExam(String examName, Integer number);

    boolean saveOrUpdate(Exam Exam);

    List<Exam> listExam();

    List<Exam> listExamByName(String examName);

    Exam getExamById(String examName, Integer number);

    Long count(Map param);

    int getMaxNumberByExamName(String examName);
}
