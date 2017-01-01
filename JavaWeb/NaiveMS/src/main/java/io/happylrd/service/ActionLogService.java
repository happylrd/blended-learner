package io.happylrd.service;

import io.happylrd.model.UserActionLog;

import java.util.List;

public interface ActionLogService extends BaseService<UserActionLog> {
    void add(UserActionLog userActionLog) throws Exception;

    List<UserActionLog> findAll(int pageNum, int pageSize);

    int getAllCount();
}
