package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IBasicInfoDao;
import com.buptsse.spm.domain.BasicInfo;
import com.buptsse.spm.service.IBasicInfoService;

@Transactional
@Service
public class BasicInfoServiceImpl implements IBasicInfoService {

    @Resource
    private IBasicInfoDao iBasicInfoDao;

    @Override
    public boolean insertBasicInfo(BasicInfo basicInfo) {
        return iBasicInfoDao.saveBasicInfo(basicInfo);
    }

    @Override
    public boolean deleteBasicInfo(String id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(BasicInfo basicInfo) {
        return iBasicInfoDao.saveOrUpdateBasicInfo(basicInfo);
    }

    @Override
    public BasicInfo findBasicInfoById(String id) {
        return iBasicInfoDao.getBasicInfoById(new Integer(id));
    }

    @Override
    public BasicInfo findBasicInfoByName(String name) {
        String hql = " from BasicInfo where name=?";
        List<Object> listParm = new ArrayList<>();
        listParm.add(name);
        List<BasicInfo> listBasicInfo = iBasicInfoDao.listBasicInfo(hql, listParm);
        if (listBasicInfo.size() > 0) {
            return listBasicInfo.get(0);
        } else {
            return null;
        }
        //return iBasicInfoDao.findBasicInfoById(new Integer(id));
    }

    @Override
    public List<BasicInfo> findAllBasicInfo() {
        String hql = "from BasicInfo";
        List<Object> list = new ArrayList<>();
        return iBasicInfoDao.listBasicInfo(hql, list);
    }
}
