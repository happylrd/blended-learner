package com.buptsse.spm.service.impl;

import java.util.ArrayList;
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
    public boolean saveExam(Exam Exam) {
        return iExamDao.saveExam(Exam);
    }

    @Override
    public boolean removeExam(String examName, Integer number) {
        Exam exam = this.getExamById(examName, number);
        return iExamDao.removeExam(exam);
    }

    @Override
    public boolean saveOrUpdate(Exam exam) {
        return iExamDao.saveOrUpdateExam(exam);
    }

    @Override
    public List<Exam> listExam() {
        String hql = "select distinct examName from Exam";
        List<Object> list = new ArrayList<>();
        return iExamDao.listExam(hql, list);
    }

    @Override
    public List<Exam> listExamByName(String examName) {
        String hql = "from Exam where examName = ? order by number ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(examName);
        return iExamDao.listExam(hql, listParam);
    }

    @Override
    public Exam getExamById(String examName, Integer number) {
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
    public Long count(Map param) {
        StringBuilder hql = new StringBuilder("select count(*) from Exam where 1=1");
        List<Object> paramList = new ArrayList<>();

        for (Object keyItem : param.keySet()) {
            String key = (String) keyItem;
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql.append("and ").append(key).append("=? ");
                paramList.add(value);
            }
        }

        return iExamDao.countExam(hql.toString(), paramList);
    }

    @Override
    public int getMaxNumberByExamName(String examName) {
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
}
