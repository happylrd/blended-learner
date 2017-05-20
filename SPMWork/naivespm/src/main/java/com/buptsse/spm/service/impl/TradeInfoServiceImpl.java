package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.ITradeInfoDao;
import com.buptsse.spm.domain.TradeInfo;
import com.buptsse.spm.service.ITradeInfoService;

@Transactional
@Service
public class TradeInfoServiceImpl implements ITradeInfoService {

    @Resource
    private ITradeInfoDao iTradeInfoDao;

    @Override
    public boolean saveTradeInfo(TradeInfo tradeInfo) {
        return iTradeInfoDao.saveTradeInfo(tradeInfo);
    }

    @Override
    public boolean saveOrUpdate(TradeInfo TradeInfo) {
        return false;
    }

    @Override
    public List<TradeInfo> listTradeInfo() {
        String hql = "from TradeInfo";
        List<Object> list = new ArrayList<>();
        return iTradeInfoDao.listTradeInfo(hql, list);
    }

    @Override
    public TradeInfo getTradeInfoById(String id) {
        return iTradeInfoDao.getTradeInfoById(new Integer(id));
    }
}
