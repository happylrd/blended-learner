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
    public TradeInfo findTradeInfoById(String id) {
        return iTradeInfoDao.getTradeInfoById(new Integer(id));
    }

    @Override
    public boolean insertTradeInfo(TradeInfo tradeInfo) {
        return iTradeInfoDao.saveTradeInfo(tradeInfo);
    }

    @Override
    public List<TradeInfo> findAllTradeInfo() {
        String hql = "from TradeInfo";
        List<Object> list = new ArrayList<>();
        return iTradeInfoDao.listTradeInfo(hql, list);
    }

    @Override
    public boolean deleteTradeInfo(String id) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TradeInfo TradeInfo) {
        return false;
    }

    public ITradeInfoDao getiTradeInfoDao() {
        return iTradeInfoDao;
    }

    public void setiTradeInfoDao(ITradeInfoDao iTradeInfoDao) {
        this.iTradeInfoDao = iTradeInfoDao;
    }
}
