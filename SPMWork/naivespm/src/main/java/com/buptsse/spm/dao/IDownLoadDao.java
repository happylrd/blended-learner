package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.DownLoad;

// 文件下载持久层接口
public interface IDownLoadDao {

    boolean saveDownLoad(DownLoad downLoad);

    boolean updateDownLoad(DownLoad downLoad);

    boolean removeDownLoad(DownLoad downLoad);

    boolean saveOrUpdateDownLoad(DownLoad downLoad);

    List<DownLoad> listDownLoad(String hql, Object[] param);

    List<DownLoad> listDownLoad(String hql, List<Object> param);

    DownLoad getDownLoadById(Integer id);

    Long countDownLoad(String hql, List<Object> param);
}
