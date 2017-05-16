package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.ISpChapterVideoDao;
import com.buptsse.spm.domain.SpChapterVideo;
import com.buptsse.spm.service.ISpChapterVideoService;

@Transactional
@Service
public class SpChapterVideoServiceImpl implements ISpChapterVideoService {

    @Resource
    private ISpChapterVideoDao iSpChapterVideoDao;

    @Override
    public SpChapterVideo findSpChapterVideoById(String id) {
        return iSpChapterVideoDao.getSpChapterVideoById(new Integer(id));
    }

    public List<SpChapterVideo> findSpChapterVideoByChapterId(Integer chapterId) {
        String hql = "from SpChapterVideo where chapter_id=? ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(chapterId);
        return iSpChapterVideoDao.listSpChapterVideo(hql, listParam);
    }

    public List<SpChapterVideo> findSpChapterVideoByStepOrder(Integer stepOrder) {
        String hql = "from SpChapterVideo where video_step_order=? ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(stepOrder);
        return iSpChapterVideoDao.listSpChapterVideo(hql, listParam);
    }

    @Override
    public boolean insertSpChapterVideo(SpChapterVideo SpChapterVideo) {
        return iSpChapterVideoDao.saveSpChapterVideo(SpChapterVideo);
    }

    @Override
    public List<SpChapterVideo> findAllSpChapterVideo() {
        String hql = "from SpChapterVideo";
        List<Object> list = new ArrayList<>();
        return iSpChapterVideoDao.listSpChapterVideo(hql, list);
    }

    @Override
    public boolean deleteSpChapterVideo(String id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(SpChapterVideo SpChapterVideo) {
        return false;
    }

    public ISpChapterVideoDao getiSpChapterVideoDao() {
        return iSpChapterVideoDao;
    }

    public void setiSpChapterVideoDao(ISpChapterVideoDao iSpChapterVideoDao) {
        this.iSpChapterVideoDao = iSpChapterVideoDao;
    }
}
