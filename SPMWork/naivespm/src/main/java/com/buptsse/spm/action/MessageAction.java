package com.buptsse.spm.action;

import com.buptsse.spm.domain.Message;
import com.buptsse.spm.service.IMessageService;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Message Board Action
 */
public class MessageAction extends BaseAction implements ModelDriven<Message> {

    @Resource
    private IMessageService messageService;

    private Message message = new Message();

    private List<Message> messageList = new ArrayList<>();

    @Override
    public Message getModel() {
        return message;
    }

    public String publishMessage() {
        if (messageService.saveMessage(message)) {
            return SUCCESS;
        }
        return ERROR;
    }

    public String listMessage() {
        messageList = messageService.listMessage();
        if (messageList.size() > 0) {
            return SUCCESS;
        }
        return ERROR;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
