package com.buptsse.spm.action;

import com.buptsse.spm.domain.User;
import com.buptsse.spm.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    @Resource
    private IUserService userService;

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    public String login() {
        boolean isSuccess = userService.login(user.getUsername(), user.getPassword());
        if (isSuccess) {
            return SUCCESS;
        }
        return ERROR;
    }

    public String register() {
        // TODO: check will be added later
        boolean isSuccess = userService.register(user);
        if (isSuccess) {
            return SUCCESS;
        }
        return ERROR;
    }
}
