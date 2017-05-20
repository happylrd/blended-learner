package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IDownLoadDao;
import com.buptsse.spm.domain.DownLoad;
import com.buptsse.spm.service.IDownLoadService;

@Transactional
@Service
public class DownLoadServiceImpl implements IDownLoadService {

    @Resource
    private IDownLoadDao iDownLoadDao;

    @Override
    public boolean saveDownLoad(DownLoad downLoad) {
        return iDownLoadDao.saveDownLoad(downLoad);
    }

    @Override
    public boolean removeDownLoad(String id) {
        DownLoad downLoad = getDownLoadById(id);
        return iDownLoadDao.removeDownLoad(downLoad);
    }

    @Override
    public boolean saveOrUpdate(DownLoad downLoad) {
        return false;
    }

    @Override
    public List<DownLoad> listDownLoad() {
        String hql = "from DownLoad";
        List<Object> list = new ArrayList<>();
        return iDownLoadDao.listDownLoad(hql, list);
    }

    @Override
    public DownLoad getDownLoadById(String id) {
        return iDownLoadDao.getDownLoadById(new Integer(id));
    }
}
