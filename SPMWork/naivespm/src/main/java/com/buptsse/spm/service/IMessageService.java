package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.Message;

public interface IMessageService {

    boolean saveMessage(Message message);

    boolean removeMessage(Integer id);

    boolean saveOrUpdate(Message message);

    List<Message> listMessage();
}
