package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IScheduleDao;
import com.buptsse.spm.domain.Schedule;
import com.buptsse.spm.service.IScheduleService;

@Transactional
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Resource
    private IScheduleDao iScheduleDao;

    @Override
    public boolean saveOrUpdate(Schedule schedule) {
        return iScheduleDao.saveOrUpdateSchedule(schedule);
    }

    @Override
    public List<Schedule> listByStepOrderAndUserId(Integer stepOrder, String userId) {
        String hql = "from Schedule where userId=? and video_step_order=?";
        List<Object> listParam = new ArrayList<>();
        listParam.add(userId);
        listParam.add(stepOrder);
        return iScheduleDao.listSchedule(hql, listParam);
    }

    @Override
    public List<Schedule> listByChapterIdAndUserId(Integer chapterId, String userId) {
        String hql = "from Schedule where userId=? and chapter_id=?";
        List<Object> listParam = new ArrayList<>();
        listParam.add(userId);
        listParam.add(chapterId);
        return iScheduleDao.listSchedule(hql, listParam);
    }
}
