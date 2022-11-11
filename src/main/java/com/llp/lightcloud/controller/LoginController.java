package com.llp.lightcloud.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author llp
 * {@code @date} 2022年11月11日11:43
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

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

}
