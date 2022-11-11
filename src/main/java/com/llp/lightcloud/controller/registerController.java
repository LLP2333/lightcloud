package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author llp
 * {@code @date} 2022年11月11日19:38
 */
@Controller
public class registerController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user)
    {
        boolean result = userService.saveOrUpdate(user);
        if (result)
            return "succeed";
        return "error";

    }
}
