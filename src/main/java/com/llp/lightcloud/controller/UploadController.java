package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.service.UserFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author llp
 * {@code @date} 2022年11月11日21:15
 */
@Controller
public class UploadController {
    @Autowired
    UserFilesService userFilesService;

    @ResponseBody
    @RequestMapping("/upload")
    public String uploadFiles(@RequestPart("files") MultipartFile[] files,
                              HttpServletRequest request) throws IOException {
        //从session获取用户信息
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        boolean result=false;
        if(user!=null)
        {
            User theUser=(User) user;
            result = userFilesService.uploadFiles(files, theUser);
        }
        if (result) return "succeed";
        return "error";
    }
}
