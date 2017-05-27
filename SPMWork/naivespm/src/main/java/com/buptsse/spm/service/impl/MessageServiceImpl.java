package com.buptsse.spm.service.impl;

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
    public boolean saveMessage(Message message) {
        return iMessageDao.saveMessage(message);
    }

    @Override
    public List<Message> listMessage() {
        return iMessageDao.listMessage();
    }
}
