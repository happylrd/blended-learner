package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.ConfigInfo;

public interface IConfigInfoService {

    boolean removeConfigInfo(Integer id);

    boolean saveOrUpdate(ConfigInfo configInfo);

    List<ConfigInfo> listConfigInfo();

    ConfigInfo getConfigInfoByTypeAndCode(String configType, String configValue);
}
