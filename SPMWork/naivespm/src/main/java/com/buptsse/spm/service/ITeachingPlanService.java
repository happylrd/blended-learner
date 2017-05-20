package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.TeachingPlan;

public interface ITeachingPlanService {

    boolean saveTeachingPlan(TeachingPlan teachingPlan);

    boolean removeTeachingPlan(Integer id);

    boolean saveOrUpdate(TeachingPlan teachingPlan);

    List<TeachingPlan> listTeachingPlan();
}
