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
    public Schedule findScheduleById(String id) {
        return iScheduleDao.getScheduleById(new Integer(id));
    }

    @Override
    public boolean insertSchedule(Schedule schedule) {
        return iScheduleDao.saveSchedule(schedule);
    }

    @Override
    public List<Schedule> findAllSchedule() {
        String hql = "from Schedule";
        List<Object> list = new ArrayList<>();
        return iScheduleDao.listSchedule(hql, list);
    }

    @Override
    public List<Schedule> findScheduleByUserIdAndStepOrder(Integer stepOrder, String userId) {
        String hql = "from Schedule where userId=? and video_step_order=?";
        List<Object> listParam = new ArrayList<>();
        listParam.add(userId);
        listParam.add(stepOrder);
        return iScheduleDao.listSchedule(hql, listParam);
    }

    @Override
    public boolean deleteSchedule(String id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Schedule schedule) {
        //List<Schedule> list = this.findScheduleByUserIdAndStepOrder(schedule.getVideo_step_order(), schedule.getUserid());

        //if(list!=null && list.size()>0){
        //	Schedule scheduleTmp = list.get(0);
        //	scheduleTmp.setPercent(schedule.getPercent());
        //}
        //return false;

        return iScheduleDao.saveOrUpdateSchedule(schedule);
    }


    @Override
    public List<Schedule> findScheduleByUserIdAndChapterId(Integer chapterId,
                                                           String userId) {
        String hql = "from Schedule where userId=? and chapter_id=?";
        List<Object> listParam = new ArrayList<>();
        listParam.add(userId);
        listParam.add(chapterId);
        return iScheduleDao.listSchedule(hql, listParam);
    }

    public IScheduleDao getiScheduleDao() {
        return iScheduleDao;
    }

    public void setiScheduleDao(IScheduleDao iScheduleDao) {
        this.iScheduleDao = iScheduleDao;
    }
}
