package com.buptsse.spm.service;

import com.buptsse.spm.domain.BasicInfo;

public interface IBasicInfoService {

    // TODO: will move to dao layer later
    boolean saveOrUpdate(BasicInfo basicInfo);

    BasicInfo getBasicInfoByName(String name);
}
