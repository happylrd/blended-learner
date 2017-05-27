package com.buptsse.spm.action;

import com.buptsse.spm.common.Const;
import com.buptsse.spm.domain.User;
import com.buptsse.spm.service.IUserService;
import com.opensymphony.xwork2.ModelDriven;

import javax.annotation.Resource;

public class UserAction extends BaseAction implements ModelDriven<User> {

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
            session.setAttribute(Const.CURRENT_USER, (user.getUsername() != null) ? user : null);
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

    public String logout() {
        session.removeAttribute(Const.CURRENT_USER);
        return SUCCESS;
    }
}
