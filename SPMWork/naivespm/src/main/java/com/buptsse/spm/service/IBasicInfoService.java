package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.BasicInfo;

public interface IBasicInfoService {

    boolean insertBasicInfo(BasicInfo basicInfo);

    boolean deleteBasicInfo(String id);

    boolean saveOrUpdate(BasicInfo basicInfo);

    List<BasicInfo> findAllBasicInfo();

    BasicInfo findBasicInfoById(String id);

    BasicInfo findBasicInfoByName(String name);
}
