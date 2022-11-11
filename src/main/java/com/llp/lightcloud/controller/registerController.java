package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author llp
 * {@code @date} 2022年11月11日19:38
 */
@Controller
public class registerController {

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user)
    {

        return null;
    }
}
