package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.Message;

// 留言板持久层接口
public interface IMessageDao {

    boolean saveMessage(Message message);

    List<Message> listMessage();
}
