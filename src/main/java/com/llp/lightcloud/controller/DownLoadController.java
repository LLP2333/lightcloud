package com.llp.lightcloud.controller;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import com.llp.lightcloud.service.UserFilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * @author llp
 * {@code @date} 2022年11月12日15:25
 */
@Controller
@Slf4j
public class DownLoadController {
    @Autowired
    UserFilesService userFilesService;

    @ResponseBody
    @RequestMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id,
                                               HttpServletRequest request,
                                               HttpServletResponse response) throws IOException {
        //校验该用户是否有文件访问权限
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String username = user.getUsername();
        UserFiles userFiles = userFilesService.getById(id);
        if(!username.equals(userFiles.getUsername()))
        {
            log.info("访问非法");
            response.sendRedirect("/home");
        }

        //获取文件真实的名字
        String filepath = userFiles.getFilepath();

        //解决文件名中文变成下划线的问题
        filepath=new String(filepath.getBytes(StandardCharsets.UTF_8),"ISO8859-1");
        String s="attachment;filename="+filepath;
        log.info("s={}",s);

        //文件数据保存到byte数组
        byte[] bytes = userFilesService.getDownloadFile(id);

        //设置HttpHeaders
        MultiValueMap<String,String> headers=new HttpHeaders();
        headers.add("Content-Disposition",s);
        headers.add("Content-Type", "application/octet-stream");
        HttpStatus httpStatus=HttpStatus.OK;

        //设置要返回的数据
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,httpStatus);
        return responseEntity;
    }
}
