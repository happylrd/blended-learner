package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IMessageDao;
import com.buptsse.spm.domain.Message;

@Repository
public class MessageDaoImpl extends BaseDAOImpl<Message> implements IMessageDao {

    private static Logger logger = Logger.getLogger(MessageDaoImpl.class);

    private Session getCurrentSession() {
        return super.getSessionFactory().getCurrentSession();
    }

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
    public List<Message> listMessage() {
        String hql = "from Message";
        Query query = getCurrentSession().createQuery(hql);
        return query.list();
    }
}
