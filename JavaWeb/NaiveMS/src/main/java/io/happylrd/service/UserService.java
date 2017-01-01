package io.happylrd.service;

import io.happylrd.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    void add(User user) throws Exception;

    List<User> findAll(int pageNum, int pageSize);

    User findUser(User user) throws Exception;

    void updateLoginSession(String sessionId, String username);
}
