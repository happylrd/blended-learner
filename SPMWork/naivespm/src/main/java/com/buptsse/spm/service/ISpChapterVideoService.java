package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.SpChapterVideo;

public interface ISpChapterVideoService {

    boolean saveOrUpdate(SpChapterVideo spChapterVideo);

    List<SpChapterVideo> listByChapterId(Integer chapterId);

    List<SpChapterVideo> listByStepOrder(Integer stepOrder);
}
