package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.ISelectCourseDao;
import com.buptsse.spm.domain.Course;
import com.buptsse.spm.service.ISelectCourseService;

@Transactional
@Service
public class SelectCourseServiceImpl implements ISelectCourseService {

    @Resource
    private ISelectCourseDao iSelectCourseDao;

    @Override
    public boolean saveCourse(Course course) {
        try {
            iSelectCourseDao.saveCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean saveOrUpdate(Course course) {
        return iSelectCourseDao.saveOrUpdateCourse(course);
    }

    @Override
    public Course getByStudentId(String studentId) {
        return iSelectCourseDao.getCourse(studentId);
    }

    @Override
    public List<Course> listByPage(Map param, Integer pageNum, Integer pageSize) {
        StringBuilder hql = new StringBuilder("from Course where 1=1 ");
        List<Object> paramList = new ArrayList<>();

        for (Object keyItem : param.keySet()) {
            String key = (String) keyItem;
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql.append("and ").append(key).append("=? ");
                paramList.add(value);
            }
        }

        return iSelectCourseDao.listCourseByPage(hql.toString(), paramList, pageNum, pageSize);
    }

    @Override
    public Long count(Map param) {
        StringBuilder hql = new StringBuilder("select count(*) from Course where 1=1 ");
        List<Object> paramList = new ArrayList<>();

        for (Object keyItem : param.keySet()) {
            String key = (String) keyItem;
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql.append("and ").append(key).append("=? ");
                paramList.add(value);
            }
        }

        return iSelectCourseDao.countCourse(hql.toString(), paramList);
    }

    @Override
    public boolean changeStatus(String studentId, int newStatus) {
        Course course = iSelectCourseDao.getCourse(studentId);
        switch (newStatus) {
            case 1:
                //course.setStatus("待确认");
                course.setStatus("1");
                iSelectCourseDao.updateCourse(course);
                break;
            case 2:
                //course.setStatus("选课成功");
                course.setStatus("2");
                iSelectCourseDao.updateCourse(course);
                break;
            case 3:
                //course.setStatus("未选");
                course.setStatus("3");
                iSelectCourseDao.updateCourse(course);
                break;
            case 4:
                iSelectCourseDao.removeCourse(course);
                break;
            default:
                break;
        }
        return true;
    }
}
