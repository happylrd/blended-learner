package com.buptsse.spm.service;

import java.util.List;

import com.buptsse.spm.domain.Message;

public interface IMessageService {

    boolean saveMessage(Message message);

    List<Message> listMessage();
}
