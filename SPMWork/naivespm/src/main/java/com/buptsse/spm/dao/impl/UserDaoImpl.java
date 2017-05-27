package com.buptsse.spm.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.buptsse.spm.dao.IUserDao;
import com.buptsse.spm.domain.User;

@Repository
public class UserDaoImpl extends BaseDAOImpl<User> implements IUserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    private Session getCurrentSession() {
        return super.getSessionFactory().getCurrentSession();
    }

    @Override
    public Long checkUsername(String username) {
        String hql = "select count(*) from User where username = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0, username);

        return (Long) query.uniqueResult();
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        String hql = "from User where username = ? and password = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, password);

        return (User) query.uniqueResult();
    }

    @Override
    public boolean saveUser(User user) {
        try {
            getCurrentSession().save(user);
        } catch (Exception e) {
            e.printStackTrace();
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
    public Long countUser(String hql, List<Object> param) {
        return super.count(hql, param);
    }
}
