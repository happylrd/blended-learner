package io.happylrd.test.service;

import io.happylrd.exception.*;
import io.happylrd.model.User;
import io.happylrd.service.serviceImpl.UserServiceImpl;
import io.happylrd.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testAdd() {
        User user = new User();
        try {
            userService.add(user);
        } catch (OtherThingsException e) {
            e.printStackTrace();
        }
    }
}
