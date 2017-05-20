package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.Schedule;

public interface IScheduleService {

    boolean saveOrUpdate(Schedule schedule);

    List<Schedule> listByStepOrderAndUserId(Integer stepOrder, String userId);

    List<Schedule> listByChapterIdAndUserId(Integer chapterId, String userId);
}
