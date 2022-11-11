package com.llp.lightcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author llp
 * {@code @date} 2022年11月11日21:15
 */
@Controller
public class UploadController {
    @ResponseBody
    @RequestMapping("/upload")
    public String uploadFiles()
    {

        return null;
    }
}
