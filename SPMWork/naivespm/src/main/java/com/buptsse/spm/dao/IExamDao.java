package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.Exam;

// 在线测试持久层接口
public interface IExamDao {

    boolean saveExam(Exam exam);

    boolean updateExam(Exam exam);

    boolean removeExam(Exam exam);

    boolean saveOrUpdateExam(Exam exam);

    List<Exam> listExam(String hql, Object[] param);

    List<Exam> listExam(String hql, List<Object> param);

    List<Exam> listExamByPage(String hql, List<Object> param, Integer pageNum, Integer pageSize);

    Long countExam(String hql, List<Object> param);
}
