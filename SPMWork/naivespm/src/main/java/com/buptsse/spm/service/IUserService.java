package com.buptsse.spm.service;

import java.util.List;
import java.util.Map;

import com.buptsse.spm.domain.User;

public interface IUserService {
    User findUser(String userName, String password);

    User findUser(String userName);

    boolean deleteUser(String id);

    boolean addUser(User user);

    boolean updateUser(User user);

    List findPage(Map param, Integer page, Integer rows);

    Long count(Map param);
}
