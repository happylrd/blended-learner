package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IConfigInfoDao;
import com.buptsse.spm.domain.ConfigInfo;

@Repository
public class ConfigInfoDaoImpl extends BaseDAOImpl<ConfigInfo> implements IConfigInfoDao {

    private static Logger logger = Logger.getLogger(ConfigInfoDaoImpl.class);

    @Override
    public boolean saveConfigInfo(ConfigInfo configInfo) {
        try {
            super.save(configInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateConfigInfo(ConfigInfo configInfo) {
        try {
            super.update(configInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeConfigInfo(ConfigInfo configInfo) {
        try {
            super.remove(configInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }


    @Override
    public boolean saveOrUpdateConfigInfo(ConfigInfo configInfo) {
        try {
            super.saveOrUpdate(configInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<ConfigInfo> listConfigInfo(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<ConfigInfo> listConfigInfo(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public ConfigInfo getConfigInfoById(Integer id) {
        return super.get(ConfigInfo.class, id);
    }

    @Override
    public Long countConfigInfo(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
