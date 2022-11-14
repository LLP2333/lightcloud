package com.llp.lightcloud.controller;

import com.llp.lightcloud.service.UserFilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author llp
 * {@code @date} 2022年11月12日17:19
 */
@Controller
@Slf4j
public class DeleteFileController {
    @Autowired
    UserFilesService userFilesService;
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteFile(@PathVariable String id)
    {
        boolean result = userFilesService.removeById(id);
        if(result) return "succeed";
        return "fail to delete the file";

    }

}
