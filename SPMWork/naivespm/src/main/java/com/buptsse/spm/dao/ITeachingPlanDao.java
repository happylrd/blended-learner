package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.TeachingPlan;

// 教案持久层接口
public interface ITeachingPlanDao {

    boolean saveTeachingPlan(TeachingPlan teachingPlan);

    boolean updateTeachingPlan(TeachingPlan teachingPlan);

    boolean removeTeachingPlan(TeachingPlan teachingPlan);

    boolean saveOrUpdateTeachingPlan(TeachingPlan teachingPlan);

    List<TeachingPlan> listTeachingPlan(String hql, Object[] param);

    List<TeachingPlan> listTeachingPlan(String hql, List<Object> param);

    TeachingPlan getTeachingPlanById(Integer id);

    Long countTeachingPlan(String hql, List<Object> param);
}
