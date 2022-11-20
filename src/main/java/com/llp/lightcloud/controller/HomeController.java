package com.llp.lightcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author llp
 * {@code @date} 2022年11月11日15:43
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHomePage()
    {
        return "home";
    }

}
