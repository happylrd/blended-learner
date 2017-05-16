package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.ISelectCourseDao;
import com.buptsse.spm.domain.Course;

@Repository
public class SelectCourseDaoImpl extends BaseDAOImpl<Course> implements ISelectCourseDao {

    private static Logger logger = Logger.getLogger(SelectCourseDaoImpl.class);

    @Override
    public boolean saveCourse(Course course) {
        try {
            super.save(course);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCourse(Course course) {
        try {
            super.update(course);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCourse(Course course) {
        try {
            super.remove(course);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    public boolean saveOrUpdateCourse(Course course) {
        try {
            super.saveOrUpdate(course);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Course> listCourse() {
        return super.list("from Course");
    }

    @Override
    public List<Course> listCourseByPage(String hql, List<Object> param,
                                         Integer pageNum, Integer pageSize) {
        return super.list(hql, param, pageNum, pageSize);
    }

    @Override
    public Course getCourse(String studentId) {
        List<Course> list =
                super.list("from Course where studentId ='" + studentId + "'");

        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Long countCourse(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
