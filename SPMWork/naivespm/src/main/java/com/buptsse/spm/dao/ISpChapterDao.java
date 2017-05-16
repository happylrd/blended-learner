package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.SpChapter;

// 视频教学持久层接口
public interface ISpChapterDao {

    boolean saveSpChapter(SpChapter spChapter);

    boolean updateSpChapter(SpChapter spChapter);

    boolean removeSpChapter(SpChapter spChapter);

    boolean saveOrUpdateSpChapter(SpChapter spChapter);

    List<SpChapter> listSpChapter(String hql);

    List<SpChapter> listSpChapter(String hql, Object[] param);

    List<SpChapter> listSpChapter(String hql, List<Object> param);

    SpChapter getSpChapterById(Integer id);

    Long countSpChapter(String hql, List<Object> param);
}
