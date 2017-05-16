package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IMessageDao;
import com.buptsse.spm.domain.Message;

@Repository
public class MessageDaoImpl extends BaseDAOImpl<Message> implements IMessageDao {

    private static Logger logger = Logger.getLogger(MessageDaoImpl.class);

    @Override
    public boolean saveMessage(Message message) {
        try {
            super.save(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateMessage(Message message) {
        try {
            super.update(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeMessage(Message message) {
        try {
            super.remove(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }


    @Override
    public boolean saveOrUpdateMessage(Message message) {
        try {
            super.saveOrUpdate(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Message> listMessage(String hql, Object[] param) {
        return super.list(hql, param);
    }

    @Override
    public List<Message> listMessage(String hql, List<Object> param) {
        return super.list(hql, param);
    }

    @Override
    public Message getMessageById(Integer id) {
        return super.get(Message.class, id);
    }

    @Override
    public Long countMessage(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
