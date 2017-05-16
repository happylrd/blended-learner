package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.ITeachingPlanDao;
import com.buptsse.spm.domain.TeachingPlan;

@Repository
public class TeachingPlanDaoImpl extends BaseDAOImpl<TeachingPlan> implements ITeachingPlanDao {

    private static Logger logger = Logger.getLogger(TeachingPlanDaoImpl.class);

    @Override
    public boolean saveTeachingPlan(TeachingPlan teachingPlan) {
        try {
            super.save(teachingPlan);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTeachingPlan(TeachingPlan teachingPlan) {
        try {
            super.update(teachingPlan);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeTeachingPlan(TeachingPlan teachingPlan) {
        try {
            super.remove(teachingPlan);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }


    @Override
    public boolean saveOrUpdateTeachingPlan(TeachingPlan teachingPlan) {
        try {
            super.saveOrUpdate(teachingPlan);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<TeachingPlan> listTeachingPlan(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<TeachingPlan> listTeachingPlan(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public TeachingPlan getTeachingPlanById(Integer id) {
        return super.get(TeachingPlan.class, id);
    }

    @Override
    public Long countTeachingPlan(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
