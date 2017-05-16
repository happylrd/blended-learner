package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IMessageDao;
import com.buptsse.spm.domain.Message;
import com.buptsse.spm.service.IMessageService;

@Transactional
@Service
public class MessageServiceImpl implements IMessageService {

    @Resource
    private IMessageDao iMessageDao;

    @Override
    public Message findMessageById(String id) {
        return iMessageDao.getMessageById(new Integer(id));
    }

    @Override
    public boolean insertMessage(Message message) {
        return iMessageDao.saveMessage(message);
    }

    @Override
    public List<Message> findAllMessage() {
        String hql = "from Message";
        List<Object> list = new ArrayList<>();
        return iMessageDao.listMessage(hql, list);
    }

    @Override
    public boolean deleteMessage(Integer id) {
        Message message = iMessageDao.getMessageById(id);
        return iMessageDao.removeMessage(message);
    }

    @Override
    public boolean saveOrUpdate(Message message) {
        return false;
    }

    public IMessageDao getiMessageDao() {
        return iMessageDao;
    }

    public void setiMessageDao(IMessageDao iMessageDao) {
        this.iMessageDao = iMessageDao;
    }
}
