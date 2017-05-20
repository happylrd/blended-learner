package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.SpChapter;

public interface ISpChapterService {

    boolean saveOrUpdate(SpChapter spChapter);

    List<SpChapter> listSpChapterDetail();
}
