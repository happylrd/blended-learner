package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.buptsse.spm.dao.IUserDao;
import com.buptsse.spm.domain.User;
import com.buptsse.spm.service.IUserService;

@Transactional
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao iUserDao;

    @Override
    public boolean saveUser(User user) {
        return iUserDao.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return iUserDao.updateUser(user);
    }

    @Override
    public boolean removeUser(String id) {
        User user = iUserDao.getUserById(id);
        return iUserDao.removeUser(user);
    }

    @Override
    public List<User> listUserByPage(Map param, Integer pageNum, Integer pageSize) {
        StringBuilder hql = new StringBuilder("from User where 1=1 ");
        List<Object> paramList = new ArrayList<>();

        for (Object keyItem : param.keySet()) {
            String key = (String) keyItem;
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql.append("and ").append(key).append("=? ");
                paramList.add(value);
            }
        }

        return iUserDao.listUserByPage(hql.toString(), paramList, pageNum, pageSize);
    }

    @Override
    public User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user.setId(username);
        user = iUserDao.getUser(user);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = iUserDao.getUser(user);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    public Long count(Map param) {
        StringBuilder hql = new StringBuilder("select count(*) from User where 1=1 ");
        List<Object> paramList = new ArrayList<>();

        for (Object keyItem : param.keySet()) {
            String key = (String) keyItem;
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql.append("and ").append(key).append("=? ");
                paramList.add(value);
            }
        }
        return iUserDao.countUser(hql.toString(), paramList);
    }
}
