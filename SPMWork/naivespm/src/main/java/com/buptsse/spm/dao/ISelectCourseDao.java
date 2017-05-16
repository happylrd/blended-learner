package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.Course;

// 选课持久层接口
public interface ISelectCourseDao {

    boolean saveCourse(Course course);

    boolean updateCourse(Course course);

    boolean removeCourse(Course course);

    boolean saveOrUpdateCourse(Course course);

    List<Course> listCourse();

    List<Course> listCourseByPage(String hql, List<Object> param, Integer pageNum, Integer pageSize);

    Course getCourse(String studentId);

    Long countCourse(String hql, List<Object> param);
}
