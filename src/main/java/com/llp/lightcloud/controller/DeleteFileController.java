package com.llp.lightcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author llp
 * {@code @date} 2022年11月12日17:19
 */
@Controller
@Slf4j
public class DeleteFileController {
    @RequestMapping("/delete/{id}")
    public String deleteFile(@PathVariable String id)
    {
        return null;
    }

}
