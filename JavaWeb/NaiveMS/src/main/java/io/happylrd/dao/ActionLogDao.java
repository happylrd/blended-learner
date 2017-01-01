package io.happylrd.dao;

import io.happylrd.model.UserActionLog;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface ActionLogDao extends Dao<UserActionLog> {
    int add(UserActionLog userActionLog);

    UserActionLog findOneByUsername(Serializable username);

    /**
     * paging query
     *
     * @param offset start position
     * @param limit  number per page
     * @return
     */
    List<UserActionLog> findAll(@Param("offset") int offset, @Param("limit") int limit);

    int getAllCount();
}
