package com.buptsse.spm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.buptsse.spm.common.Const;
import com.buptsse.spm.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
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
    public boolean login(String username, String password) {
        long resultCount = iUserDao.checkUsername(username);
        if (resultCount == 0) {
            // case: user doesn't exist
            return false;
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);

        User user = iUserDao.getByUsernameAndPassword(username, md5Password);
        if (user == null) {
            // case: password error
            return false;
        }
        return true;
    }

    @Override
    public boolean register(User user) {
        boolean isValid = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!isValid) {
            return false;
        }

        // MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        return iUserDao.saveUser(user);
    }

    private boolean checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)) {
            if (Const.USERNAME.equals(type)) {
                long resultCount = iUserDao.checkUsername(str);
                if (resultCount > 0) {
                    // case: 用户名已存在
                    return false;
                }
            }
        } else {
            // case: 参数错误
            return false;
        }

        return true;
    }

    @Override
    public boolean updateUser(User user) {
        return iUserDao.updateUser(user);
    }

    @Override
    public User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
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
