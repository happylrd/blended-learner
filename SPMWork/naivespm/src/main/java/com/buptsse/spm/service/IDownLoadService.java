package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.DownLoad;

public interface IDownLoadService {

    boolean saveDownLoad(DownLoad downLoad);

    boolean removeDownLoad(String id);

    boolean saveOrUpdate(DownLoad downLoad);

    List<DownLoad> listDownLoad();

    DownLoad getDownLoadById(String id);
}
