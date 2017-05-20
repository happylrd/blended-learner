package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.TradeInfo;

public interface ITradeInfoService {

    boolean saveTradeInfo(TradeInfo TradeInfo);

    boolean saveOrUpdate(TradeInfo TradeInfo);

    List<TradeInfo> listTradeInfo();

    TradeInfo getTradeInfoById(String id);
}
