package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IExamDao;
import com.buptsse.spm.domain.Exam;
import com.buptsse.spm.service.IExamService;

@Transactional
@Service
public class ExamServiceImpl implements IExamService {

    @Resource
    private IExamDao iExamDao;

    @Override
    public Exam findExamById(String examName, Integer number) {
        String hql = "from Exam where examName = ? and number= ? ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(examName);
        listParam.add(number);
        List<Exam> listExam = iExamDao.listExam(hql, listParam);
        if (listExam.size() > 0) {
            return listExam.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List findExamByName(String examName) {
        String hql = "from Exam where examName = ? order by number ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(examName);
        return iExamDao.listExam(hql, listParam);
    }

    @Override
    public int findExamMaxId(String examName) {
        String hql = "from Exam where examName = ? order by number desc";
        List<Object> listParam = new ArrayList<>();
        listParam.add(examName);
        List<Exam> listExam = iExamDao.listExam(hql, listParam);
        if (listExam.size() > 0) {
            return listExam.get(0).getNumber();
        } else {
            return 0;
        }
    }

    @Override
    public boolean insertExam(Exam Exam) {
        return iExamDao.saveExam(Exam);
    }

    @Override
    public List<Exam> findAllExam() {
        String hql = "select distinct examName from Exam";
        List<Object> list = new ArrayList<>();
        return iExamDao.listExam(hql, list);
    }

    @Override
    public boolean deleteExam(String examName, Integer number) {
        Exam exam = this.findExamById(examName, number);
        return iExamDao.removeExam(exam);
    }

    @Override
    public boolean saveOrUpdate(Exam exam) {
        return iExamDao.saveOrUpdateExam(exam);
    }

    public IExamDao getiExamDao() {
        return iExamDao;
    }

    public void setiExamDao(IExamDao iExamDao) {
        this.iExamDao = iExamDao;
    }

    @Override
    public List findPage(Map param, Integer page, Integer rows) {
        String hql = "from Exam where 1=1 ";
        List<Object> paramList = new ArrayList<>();
        Iterator iter = param.keySet().iterator();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql += "and " + key + "=? ";
                paramList.add(value);
            }
        }

        System.out.println("进入查询的Service:" + hql);
        return iExamDao.listExamByPage(hql, paramList, page, rows);
        //return iSelectCourseDao.findAllCourse();
    }

    @Override
    public Long count(Map param) {
        String hql = "select count(*) from Exam where 1=1";
        List<Object> paramList = new ArrayList<>();
        Iterator iter = param.keySet().iterator();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = (String) param.get(key);
            System.out.println("&&&&&value&&&&:" + value);
            if (!"".equals(value)) {
                hql += "and " + key + "=? ";
                paramList.add(value);
            }
        }

        return iExamDao.countExam(hql, paramList);
    }
}
