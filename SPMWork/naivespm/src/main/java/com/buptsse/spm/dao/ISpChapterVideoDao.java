package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.SpChapterVideo;

// 视频章节信息持久层接口
public interface ISpChapterVideoDao {

    boolean saveSpChapterVideo(SpChapterVideo spChapterVideo);

    List<SpChapterVideo> listSpChapterVideo();

    List<SpChapterVideo> listSpChapterVideo(String hql, Object[] param);

    List<SpChapterVideo> listSpChapterVideo(String hql, List<Object> param);

    SpChapterVideo getSpChapterVideoById(Integer id);
}
