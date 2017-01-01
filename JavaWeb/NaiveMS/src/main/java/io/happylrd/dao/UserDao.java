package io.happylrd.dao;

import io.happylrd.model.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends Dao<User> {
    int add(User user);

    int delete(User user);

    int update(User user);

    User findOneByUsername(Serializable username);

    List<User> findAll();

    // need to modify
    void updateLoginSession(@Param("sessionId") String sessionId, @Param("username") String username);
}
