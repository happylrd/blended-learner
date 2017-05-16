package com.buptsse.spm.dao;

import java.util.List;

import com.buptsse.spm.domain.User;

public interface IUserDao {

    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean removeUser(User user);

    List listUserByPage(String hql, List<Object> param, Integer pageNum, Integer pageSize);

    User getUser(User user);

    User getUserById(String id);

    Long countUser(String hql, List<Object> param);
}
