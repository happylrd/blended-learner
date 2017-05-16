package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.ITradeInfoDao;
import com.buptsse.spm.domain.TradeInfo;

@Repository
public class TradeInfoImpl extends BaseDAOImpl<TradeInfo> implements ITradeInfoDao {

    private static Logger logger = Logger.getLogger(TradeInfoImpl.class);

    @Override
    public boolean saveTradeInfo(TradeInfo tradeInfo) {
        try {
            super.save(tradeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTradeInfo(TradeInfo tradeInfo) {
        try {
            super.update(tradeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeTradeInfo(TradeInfo tradeInfo) {
        try {
            super.remove(tradeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdateTradeInfo(TradeInfo TradeInfo) {
        try {
            super.saveOrUpdate(TradeInfo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<TradeInfo> listTradeInfo(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<TradeInfo> listTradeInfo(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public TradeInfo getTradeInfoById(Integer id) {
        return super.get(TradeInfo.class, id);
    }

    @Override
    public Long countTradeInfo(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
