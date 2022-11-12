package com.llp.lightcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
