package com.buptsse.spm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import com.buptsse.spm.service.IUserService;

public class DwrUtil {

    @Resource
    private IUserService userService;

    /**
     * @param username
     * @return boolean 判定用户名是否为数字，是返回true，否则false
     */
    public boolean isNumeric(String username) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(username);
        return isNum.matches();
    }

    public String loginCheck(String userName, String passwWord) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(passwWord)) {
            return "账号或密码未输入！";
        }
        if (userService.getByUsernameAndPassword(userName, passwWord) == null) {
            return "对不起，该用户不存在或密码输入错误！";
        }

        return "1";
    }

    /**
     * @param userName 用户名
     * @return String 检测用户名输入是否有效：10位数字，返回相应字符串
     */
    public String extenceCheck(String userName) {
        if (StringUtils.isBlank(userName)) {
            return "用户名不可为空";
        } else if (!isNumeric(userName) || userName.length() != 10) {
            return "用户名应为10位数字";
        } else {
            if (userService.getByUsername(userName) != null) {
                System.out.println("用户已存在，请重新输入");

                // 这tm原来是exist...

                return "extence";
            } else {
                // 满足可以注册的条件
                return "unExtence";
            }
        }
//        return "success";
    }

    public String registerCheck(String username, String password,
                                String passwordAgain) {

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)
                || StringUtils.isBlank(passwordAgain)) {
            return "error";
        } else if (!isNumeric(username) || username.length() != 10) {
            return "error";
        } else {
            if (password.equals(passwordAgain)) {
                return "success";
            } else {
                return "error";
            }
        }
    }
}
