package io.happylrd.mvc.controller;

import io.happylrd.model.ResponseObj;
import io.happylrd.model.User;
import io.happylrd.service.serviceImpl.UserServiceImpl;
import io.happylrd.utils.GsonUtils;
import io.happylrd.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userAction")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    private ResponseObj responseObj;

    @RequestMapping(value = "/doSignUp"
            , method = RequestMethod.POST
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object doSignUp(HttpServletRequest request, HttpServletResponse response,
                           User user, HttpSession session) {
        Object result;
        responseObj = new ResponseObj<User>();
        if (null == user) {
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("用户信息不能为空！");
            result = new GsonUtils().toJson(responseObj);
            return result;
        }
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("用户名或密码不能为空！");
            result = new GsonUtils().toJson(responseObj);
            return result;
        }
        if (null != userService.findUser(user)) {
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("用户已经存在！");
            result = new GsonUtils().toJson(responseObj);
            return result;
        }

        try {
            userService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("其他错误！");
            result = new GsonUtils().toJson(responseObj);
            return result;
        }
        responseObj.setCode(ResponseObj.OK);
        responseObj.setMsg("注册成功");
        user.setPassword(session.getId());
        user.setNextUrl(request.getContextPath() + "/mvc/home");
        responseObj.setData(user);
        session.setAttribute("userInfo", user);
        result = new GsonUtils().toJson(responseObj);
        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8"})
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response,
                        User user, HttpSession session) {
        Object result;
        if (null == user) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("登录信息不能为空");
            result = new GsonUtils().toJson(responseObj);
            return result;
        }
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("用户名或密码不能为空");
            result = new GsonUtils().toJson(responseObj);
            return result;
        }

        User user1 = userService.findUser(user);
        if (null == user1) {
            responseObj = new ResponseObj<User>();
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("未找到该用户");
            result = new GsonUtils().toJson(responseObj);
        } else {
            if (user.getPassword().equals(user1.getPassword())) {
                user1.setPassword(session.getId());
                user1.setNextUrl(request.getContextPath() + "/mvc/home");

                responseObj = new ResponseObj<User>();
                responseObj.setCode(ResponseObj.OK);
                responseObj.setMsg(ResponseObj.OK_STR);
                responseObj.setData(user1);

                session.setAttribute("userInfo", user1);
                result = new GsonUtils().toJson(responseObj);
            } else {
                responseObj = new ResponseObj<User>();
                responseObj.setCode(ResponseObj.FAILED);
                responseObj.setMsg("用户密码错误");
                result = new GsonUtils().toJson(responseObj);
            }
        }
        return result;
    }

    @RequestMapping(value = "/findOneUser"
            , produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object findOneUser(String username) {
        ResponseObj<User> responseObj = new ResponseObj<User>();

        User result = userService.findUserByUsername(username);
        if (result == null) {
            responseObj.setCode(ResponseObj.EMPTY);
            responseObj.setMsg("查询结果为空");
            return new GsonUtils().toJson(responseObj);
        }
        responseObj.setCode(ResponseObj.OK);
        responseObj.setMsg("查询成功");
        responseObj.setData(result);
        return new GsonUtils().toJson(responseObj);
    }
}
