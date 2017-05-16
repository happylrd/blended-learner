package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.TradeInfo;

// 行业信息持久层接口
public interface ITradeInfoDao {

    boolean saveTradeInfo(TradeInfo tradeInfo);

    boolean updateTradeInfo(TradeInfo tradeInfo);

    boolean removeTradeInfo(TradeInfo tradeInfo);

    boolean saveOrUpdateTradeInfo(TradeInfo tradeInfo);

    List<TradeInfo> listTradeInfo(String hql, Object[] param);

    List<TradeInfo> listTradeInfo(String hql, List<Object> param);

    TradeInfo getTradeInfoById(Integer id);

    Long countTradeInfo(String hql, List<Object> param);
}
