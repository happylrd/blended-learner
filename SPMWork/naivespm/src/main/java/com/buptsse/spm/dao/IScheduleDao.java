package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.Schedule;

// 视频调度持久层接口
public interface IScheduleDao {

    boolean saveSchedule(Schedule schedule);

    boolean updateSchedule(Schedule schedule);

    boolean removeSchedule(Schedule schedule);

    boolean saveOrUpdateSchedule(Schedule schedule);

    List<Schedule> listSchedule(String hql, Object[] param);

    List<Schedule> listSchedule(String hql, List<Object> param);

    Schedule getScheduleById(Integer id);

    Long countSchedule(String hql, List<Object> param);
}
