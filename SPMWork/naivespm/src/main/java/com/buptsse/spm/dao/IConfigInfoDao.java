package com.buptsse.spm.dao;

import java.util.List;
import com.buptsse.spm.domain.ConfigInfo;

// 留言板持久层接口
public interface IConfigInfoDao {

    boolean saveConfigInfo(ConfigInfo ConfigInfo);

    boolean updateConfigInfo(ConfigInfo ConfigInfo);

    boolean removeConfigInfo(ConfigInfo ConfigInfo);

    boolean saveOrUpdateConfigInfo(ConfigInfo ConfigInfo);

    List<ConfigInfo> listConfigInfo(String hql, Object[] param);

    List<ConfigInfo> listConfigInfo(String hql, List<Object> param);

    ConfigInfo getConfigInfoById(Integer id);

    Long countConfigInfo(String hql, List<Object> param);
}
