package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author llp
 * {@code @date} 2022年11月12日10:27
 */
@Controller
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    //用户注册
    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        boolean result = userService.saveOrUpdate(user);
        if (result)
            return "succeed";
        return "error";

    }

    //用户登录
    @ResponseBody
    @RequestMapping("/user")
    public String login(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User returnUser = userService.loginCheck(user);
        if (returnUser != null) {
            session.setAttribute("user", returnUser);
            return "succeed";
        } else
            return "error";


    }

    //用户退出
    @ResponseBody
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        log.info("用户退出登录");
        return "succeed";

    }
}
