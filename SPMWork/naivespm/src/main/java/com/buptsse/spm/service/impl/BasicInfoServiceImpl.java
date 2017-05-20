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
    public boolean saveOrUpdate(BasicInfo basicInfo) {
        return iBasicInfoDao.saveOrUpdateBasicInfo(basicInfo);
    }

    @Override
    public BasicInfo getBasicInfoByName(String name) {
        String hql = " from BasicInfo where name=?";
        List<Object> listParm = new ArrayList<>();
        listParm.add(name);
        List<BasicInfo> listBasicInfo = iBasicInfoDao.listBasicInfo(hql, listParm);
        if (listBasicInfo.size() > 0) {
            return listBasicInfo.get(0);
        } else {
            return null;
        }
    }
}
