package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.ISpChapterVideoDao;
import com.buptsse.spm.domain.SpChapterVideo;

@Repository
public class SpChapterVideoDaoImpl extends BaseDAOImpl<SpChapterVideo> implements ISpChapterVideoDao {

    private static Logger logger = Logger.getLogger(SpChapterVideoDaoImpl.class);

    @Override
    public boolean saveSpChapterVideo(SpChapterVideo spChapterVideo) {
        try {
            super.save(spChapterVideo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<SpChapterVideo> listSpChapterVideo() {
        return super.list("from SpChapterVideo s order by s.chapter_id");
    }

    @Override
    public List<SpChapterVideo> listSpChapterVideo(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<SpChapterVideo> listSpChapterVideo(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public SpChapterVideo getSpChapterVideoById(Integer id) {
        return super.get(SpChapterVideo.class, id);
    }
}
