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
    public boolean saveOrUpdate(SpChapterVideo SpChapterVideo) {
        return false;
    }

    @Override
    public List<SpChapterVideo> listByChapterId(Integer chapterId) {
        String hql = "from SpChapterVideo where chapter_id=? ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(chapterId);
        return iSpChapterVideoDao.listSpChapterVideo(hql, listParam);
    }

    @Override
    public List<SpChapterVideo> listByStepOrder(Integer stepOrder) {
        String hql = "from SpChapterVideo where video_step_order=? ";
        List<Object> listParam = new ArrayList<>();
        listParam.add(stepOrder);
        return iSpChapterVideoDao.listSpChapterVideo(hql, listParam);
    }
}
