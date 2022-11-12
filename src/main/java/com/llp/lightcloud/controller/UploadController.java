package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import com.llp.lightcloud.service.UserFilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author llp
 * {@code @date} 2022年11月11日21:15
 */
@Controller
@Slf4j
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
    @RequestMapping(value = "/fileList",method = RequestMethod.GET)
    public String getFileList()
    {
        log.info("请求文件列表");
        return "fileList";
    }

    @ResponseBody
    @RequestMapping(value = "/fileList",method = RequestMethod.POST)
    public List<UserFiles> getFileList(HttpServletRequest request)
    {
        //执行以下语句，默认用户已经登录
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        return userFilesService.getUserFileList(user);
    }

}
