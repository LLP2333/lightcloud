package com.llp.lightcloud.controller;

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
    public ResponseEntity<byte[]> downloadFile(@PathVariable String id) throws IOException {

        UserFiles userFiles = userFilesService.getById(id);
        String filepath = userFiles.getFilepath();
        filepath=new String(filepath.getBytes(StandardCharsets.UTF_8),"ISO8859-1");
        String s="attachment;filename="+filepath;
        byte[] bytes = userFilesService.getDownloadFile(id);
        MultiValueMap<String,String> headers=new HttpHeaders();
        log.info("s={}",s);
        headers.add("Content-Disposition",s);
        headers.add("Content-Type", "application/octet-stream");
        HttpStatus httpStatus=HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,headers,httpStatus);
        return responseEntity;
    }
}
