package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.BasicInfo;

public interface IBasicInfoDao {

    boolean saveBasicInfo(BasicInfo basicInfo);

    boolean updateBasicInfo(BasicInfo basicInfo);

    boolean removeBasicInfo(BasicInfo basicInfo);

    boolean saveOrUpdateBasicInfo(BasicInfo basicInfo);

    List<BasicInfo> listBasicInfo(String hql, Object[] param);

    List<BasicInfo> listBasicInfo(String hql, List<Object> param);

    BasicInfo getBasicInfoById(Integer id);

    Long countBasicInfo(String hql, List<Object> param);
}
