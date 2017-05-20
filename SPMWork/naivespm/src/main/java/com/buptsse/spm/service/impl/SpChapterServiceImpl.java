package com.buptsse.spm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.ISpChapterDao;
import com.buptsse.spm.domain.SpChapter;
import com.buptsse.spm.service.ISpChapterService;

@Transactional
@Service
public class SpChapterServiceImpl implements ISpChapterService {

    @Resource
    private ISpChapterDao iSpChapterDao;

    @Override
    public boolean saveOrUpdate(SpChapter spChapter) {
        return false;
    }

    @Override
    public List<SpChapter> listSpChapterDetail() {
        String hql = "SELECT c.chapter_id,c.chapter_name_number,c.chapter_name,c.chapter_pic,c.chapter_desc,"
                + "SUM(cv.video_time) as sum_time,count(*) as video_size "
                + "FROM sp_chapter c,sp_chapter_video cv WHERE c.chapter_id = cv.chapter_id "
                + "GROUP BY c.chapter_id,c.chapter_name_number,c.chapter_name,c.chapter_pic,c.chapter_desc "
                + "ORDER BY c.chapter_name_number";

        return iSpChapterDao.listSpChapter(hql);
    }
}
