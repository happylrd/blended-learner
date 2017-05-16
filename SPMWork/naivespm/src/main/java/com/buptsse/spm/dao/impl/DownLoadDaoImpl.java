package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IDownLoadDao;
import com.buptsse.spm.domain.DownLoad;

@Repository
public class DownLoadDaoImpl extends BaseDAOImpl<DownLoad> implements IDownLoadDao {

    private static Logger logger = Logger.getLogger(DownLoadDaoImpl.class);

    @Override
    public boolean saveDownLoad(DownLoad downLoad) {
        try {
            super.save(downLoad);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateDownLoad(DownLoad downLoad) {
        try {
            super.update(downLoad);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeDownLoad(DownLoad downLoad) {
        try {
            super.remove(downLoad);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }


    @Override
    public boolean saveOrUpdateDownLoad(DownLoad downLoad) {
        try {
            super.saveOrUpdate(downLoad);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<DownLoad> listDownLoad(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<DownLoad> listDownLoad(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public DownLoad getDownLoadById(Integer id) {
        return super.get(DownLoad.class, id);
    }

    @Override
    public Long countDownLoad(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
