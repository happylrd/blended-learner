package com.buptsse.spm.service;

import java.util.Map;

import com.buptsse.spm.domain.User;

public interface IUserService {

    boolean login(String username, String password);

    boolean register(User user);

    // TODO: will be removed later
    boolean updateUser(User user);

    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    Long count(Map param);
}
