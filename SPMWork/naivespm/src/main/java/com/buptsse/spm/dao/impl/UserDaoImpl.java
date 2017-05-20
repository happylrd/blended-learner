package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IUserDao;
import com.buptsse.spm.domain.User;

@Repository
public class UserDaoImpl extends BaseDAOImpl<User> implements IUserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public boolean saveUser(User user) {
        try {
            super.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            super.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUser(User user) {
        try {
            super.remove(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return false;
        }
        return true;
    }

    @Override
    public List<User> listUserByPage(String hql, List<Object> param, Integer pageNum, Integer pageSize) {
        return super.list(hql, param, pageNum, pageSize);
    }

    @Override
    public User getUser(User user) {
        // TODO: will be modified with hql
        List<User> userList = super.list("from User");
        for (User userItem : userList) {
            if (user.getUsername().equals(userItem.getUsername())) {
                return userItem;
            }
        }
        return null;
    }

    @Override
    public User getUserById(String id) {
        return super.get(User.class, id);
    }

    @Override
    public Long countUser(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
