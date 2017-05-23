package com.buptsse.spm.service;

import java.util.List;
import java.util.Map;

import com.buptsse.spm.domain.User;

public interface IUserService {

    boolean login(String username, String password);

    boolean register(User user);

    boolean saveUser(User user);

    // TODO: will be removed later
    boolean updateUser(User user);

    boolean removeUser(String id);

    List<User> listUserByPage(Map param, Integer page, Integer rows);

    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    Long count(Map param);
}
