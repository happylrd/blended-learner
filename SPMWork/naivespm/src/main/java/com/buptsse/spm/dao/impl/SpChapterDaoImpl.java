package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.ISpChapterDao;
import com.buptsse.spm.domain.SpChapter;

@Repository
public class SpChapterDaoImpl extends BaseDAOImpl<SpChapter> implements ISpChapterDao {

    private static Logger logger = Logger.getLogger(SpChapterDaoImpl.class);

    @Override
    public boolean saveSpChapter(SpChapter spChapter) {
        try {
            super.save(spChapter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSpChapter(SpChapter spChapter) {
        try {
            super.update(spChapter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeSpChapter(SpChapter spChapter) {
        try {
            super.remove(spChapter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdateSpChapter(SpChapter spChapter) {
        try {
            super.saveOrUpdate(spChapter);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<SpChapter> listSpChapter(String hql) {
        return super.list(hql);
    }

    @Override
    public List<SpChapter> listSpChapter(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<SpChapter> listSpChapter(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public SpChapter getSpChapterById(Integer id) {
        return super.get(SpChapter.class, id);
    }

    @Override
    public Long countSpChapter(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
