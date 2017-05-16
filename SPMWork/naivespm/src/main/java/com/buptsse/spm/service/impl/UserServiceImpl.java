package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
    public User findUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user = iUserDao.getUser(user);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        } else {
            return user;
        }
    }

    public User findUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        user.setId(userName);
        user = iUserDao.getUser(user);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }

    @Override
    public boolean deleteUser(String id) {
        User user = iUserDao.getUserById(id);
        return iUserDao.removeUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return iUserDao.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return iUserDao.updateUser(user);
    }

    @Override
    public List findPage(Map param, Integer page, Integer rows) {
        String hql = "from User where 1=1 ";
        List<Object> paramList = new ArrayList<>();
        Iterator iter = param.keySet().iterator();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = (String) param.get(key);
            if (!"".equals(value)) {
                hql += "and " + key + "=? ";
                paramList.add(value);
            }
        }

        return iUserDao.listUserByPage(hql, paramList, page, rows);
    }

    @Override
    public Long count(Map param) {
        String hql = "select count(*) from User where 1=1 ";
        List paramList = new ArrayList();
        Iterator iter = param.keySet().iterator();

        while (iter.hasNext()) {
            String key = (String) iter.next();
            String value = (String) param.get(key);
            System.out.println("&&&&&value&&&&:" + value);
            if (!"".equals(value)) {
                hql += "and " + key + "=? ";
                paramList.add(value);
            }
        }
        return iUserDao.countUser(hql, paramList);
    }
}
