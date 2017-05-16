package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.ITeachingPlanDao;
import com.buptsse.spm.domain.TeachingPlan;
import com.buptsse.spm.service.ITeachingPlanService;

@Transactional
@Service
public class TeachingPlanServiceImpl implements ITeachingPlanService {

    @Resource
    private ITeachingPlanDao iTeachingPlanDao;

    @Override
    public TeachingPlan findTeachingPlanById(String id) {
        return iTeachingPlanDao.getTeachingPlanById(new Integer(id));
    }

    @Override
    public boolean insertTeachingPlan(TeachingPlan teachingPlan) {
        return iTeachingPlanDao.saveTeachingPlan(teachingPlan);
    }

    @Override
    public List<TeachingPlan> findAllTeachingPlan() {
        String hql = "from TeachingPlan";
        List<Object> list = new ArrayList<>();
        return iTeachingPlanDao.listTeachingPlan(hql, list);
    }

    @Override
    public boolean deleteTeachingPlan(Integer id) {
        TeachingPlan teachingPlan = iTeachingPlanDao.getTeachingPlanById(id);
        return iTeachingPlanDao.removeTeachingPlan(teachingPlan);
    }

    @Override
    public boolean saveOrUpdate(TeachingPlan teachingPlan) {
        return false;
    }

    @Override
    public List<TeachingPlan> findAllPiece() {
        //	String hql = "from TeachingPlan group by pieceid";
        String hql = "from TeachingPlan";
        List<Object> listParam = new ArrayList<>();
        return iTeachingPlanDao.listTeachingPlan(hql, listParam);
    }

    public ITeachingPlanDao getiTeachingPlanDao() {
        return iTeachingPlanDao;
    }

    public void setiTeachingPlanDao(ITeachingPlanDao iTeachingPlanDao) {
        this.iTeachingPlanDao = iTeachingPlanDao;
    }
}
