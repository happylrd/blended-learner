package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IScheduleDao;
import com.buptsse.spm.domain.Schedule;

@Repository
public class ScheduleDaoImpl extends BaseDAOImpl<Schedule> implements IScheduleDao {

    private static Logger logger = Logger.getLogger(ScheduleDaoImpl.class);

    @Override
    public boolean saveSchedule(Schedule schedule) {
        try {
            super.save(schedule);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        try {
            super.update(schedule);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeSchedule(Schedule schedule) {
        try {
            super.remove(schedule);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }


    @Override
    public boolean saveOrUpdateSchedule(Schedule schedule) {
        try {
            super.saveOrUpdate(schedule);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Schedule> listSchedule(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<Schedule> listSchedule(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        return super.get(Schedule.class, id);
    }

    @Override
    public Long countSchedule(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
