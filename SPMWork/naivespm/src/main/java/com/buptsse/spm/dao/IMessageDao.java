package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.Message;

// 留言板持久层接口
public interface IMessageDao {

    boolean saveMessage(Message message);

    boolean updateMessage(Message message);

    boolean removeMessage(Message message);

    boolean saveOrUpdateMessage(Message message);

    List<Message> listMessage(String hql, Object[] param);

    List<Message> listMessage(String hql, List<Object> param);

    Message getMessageById(Integer id);

    Long countMessage(String hql, List<Object> param);
}
