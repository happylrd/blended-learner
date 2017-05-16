package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IExamDao;
import com.buptsse.spm.domain.Exam;

@Repository
public class ExamDaoImpl extends BaseDAOImpl<Exam> implements IExamDao {

    private static Logger logger = Logger.getLogger(ExamDaoImpl.class);

    @Override
    public boolean saveExam(Exam exam) {
        try {
            super.save(exam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateExam(Exam exam) {
        try {
            super.update(exam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeExam(Exam exam) {
        try {
            super.remove(exam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdateExam(Exam exam) {
        try {
            super.saveOrUpdate(exam);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Exam> listExam(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<Exam> listExam(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public List<Exam> listExamByPage(String hql, List<Object> param, Integer pageNum, Integer pageSize) {
        return super.list(hql, param, pageNum, pageSize);
    }

    @Override
    public Long countExam(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
