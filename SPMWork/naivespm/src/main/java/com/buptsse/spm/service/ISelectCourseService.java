package com.buptsse.spm.service;

import java.util.List;
import java.util.Map;

import com.buptsse.spm.domain.Course;

public interface ISelectCourseService {

    boolean saveCourse(Course course);

    boolean saveOrUpdate(Course course);

    List<Course> listByPage(Map param, Integer pageNum, Integer pageSize);

    Course getByStudentId(String studentId);

    Long count(Map param);

    boolean changeStatus(String studnetId, int newStatus);
}
