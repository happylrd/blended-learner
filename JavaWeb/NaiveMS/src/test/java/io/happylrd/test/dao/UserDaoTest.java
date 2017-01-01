package io.happylrd.test.dao;

import io.happylrd.dao.UserDao;
import io.happylrd.model.User;
import io.happylrd.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("naivelrd");
        user.setPassword("123456");
        user.setName("管理员");
        user.setSex("男");
        int result = 0;
        try {
            result = userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加用户失败");
        }
        if (result > 0)
            System.out.println("添加用户成功");
    }

    @Test
    public void testFindOneId() throws Exception {
        User user = new User();
        user.setUsername("naivelrd");
        User result = null;
        try {
            result = userDao.findOneByUsername(user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查找用户失败");
        }
        if (null != result)
            System.out.println("查找用户成功\n" + result.toString());
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setUsername("naivelrd");
        int result = 0;
        try {
            result = userDao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除用户失败");
        }
        if (result > 0)
            System.out.println("删除用户成功");
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("naivelrd");
        user.setPassword("123456");
        user.setName("竹轩听雨");
        user.setSex("男");
        int result = 0;
        try {
            result = userDao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新用户信息失败");
        }
        if (result > 0)
            System.out.println("更新用户信息成功");

    }
}
