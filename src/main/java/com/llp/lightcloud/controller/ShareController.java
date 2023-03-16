package com.llp.lightcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author llp
 * {@code @date} 2022年11月20日21:10
 */
@Controller
@Slf4j
public class ShareController {

    //我的分享页面
    @GetMapping("/MyShare")
    public String getMySharedFile()
    {
        return "MyShare";
    }

    //分享功能
    @PostMapping("/addToShare")
    @ResponseBody
    public String addToShare()
    {
        return null;
    }
}
