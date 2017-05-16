package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IBasicInfoDao;
import com.buptsse.spm.domain.BasicInfo;

@Repository
public class BasicInfoDaoImpl extends BaseDAOImpl<BasicInfo> implements IBasicInfoDao {

    private static Logger logger = Logger.getLogger(BasicInfoDaoImpl.class);

    @Override
    public boolean saveBasicInfo(BasicInfo basicInfo) {
        try {
            super.save(basicInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBasicInfo(BasicInfo basicInfo) {
        try {
            super.update(basicInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeBasicInfo(BasicInfo basicInfo) {
        try {
            super.remove(basicInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdateBasicInfo(BasicInfo basicInfo) {
        try {
            super.saveOrUpdate(basicInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<BasicInfo> listBasicInfo(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<BasicInfo> listBasicInfo(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public BasicInfo getBasicInfoById(Integer id) {
        return super.get(BasicInfo.class, id);
    }

    @Override
    public Long countBasicInfo(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
