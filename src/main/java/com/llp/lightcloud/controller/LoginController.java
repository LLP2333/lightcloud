package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author llp
 * {@code @date} 2022年11月11日11:43
 */
@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/user")
    public String login(@RequestBody User user)
    {
        System.out.println(user);
        return "succeed";
    }

}
