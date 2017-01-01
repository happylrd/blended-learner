package io.happylrd.service.serviceImpl;

import io.happylrd.dao.UserDao;
import io.happylrd.exception.*;
import io.happylrd.model.User;
import io.happylrd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void add(User user) throws OtherThingsException {
        int result = 0;
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            System.out.println("添加用户失败,用户已经存在");
            throw new OtherThingsException(e);
        }
        if (result > 0) {
            System.out.println("添加用户成功");
        }
    }

    // just a empty implementation
    public List<User> findAll(int pageNum, int pageSize) {
        return null;
    }

    public User findUser(User user) {
        return userDao.findOneByUsername(user.getUsername());
    }

    public User findUserByUsername(String username){
        return userDao.findOneByUsername(username);
    }

    // need to modify
    public void updateLoginSession(String sessionId, String username) {
        userDao.updateLoginSession(sessionId, username);
    }
}
