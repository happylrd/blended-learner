package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IConfigInfoDao;
import com.buptsse.spm.domain.ConfigInfo;
import com.buptsse.spm.service.IConfigInfoService;

@Transactional
@Service
public class ConfigInfoServiceImpl implements IConfigInfoService {

    @Resource
    private IConfigInfoDao iConfigInfoDao;

    @Override
    public boolean removeConfigInfo(Integer id) {
        ConfigInfo ConfigInfo = iConfigInfoDao.getConfigInfoById(id);
        return iConfigInfoDao.removeConfigInfo(ConfigInfo);
    }

    @Override
    public boolean saveOrUpdate(ConfigInfo configInfo) {
        return iConfigInfoDao.saveOrUpdateConfigInfo(configInfo);
    }

    @Override
    public List<ConfigInfo> listConfigInfo() {
        String hql = "from ConfigInfo";
        List<Object> list = new ArrayList<>();
        return iConfigInfoDao.listConfigInfo(hql, list);
    }

    @Override
    public ConfigInfo getConfigInfoByTypeAndCode(String configType, String configValue) {
        String hql = "from ConfigInfo where validate='1' and configType=? and configCode=? ";
        List<Object> list = new ArrayList<>();
        list.add(configType);
        list.add(configValue);
        List<ConfigInfo> resultList = iConfigInfoDao.listConfigInfo(hql, list);
        if (resultList != null && resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return new ConfigInfo();
        }
    }
}
