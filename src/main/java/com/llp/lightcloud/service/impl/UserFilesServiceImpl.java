package com.llp.lightcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llp.lightcloud.dao.UserDao;
import com.llp.lightcloud.dao.UserFilesDao;
import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import com.llp.lightcloud.service.UserFilesService;
import com.llp.lightcloud.mapper.UserFilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
* @author NASK
* @description 针对表【user_files】的数据库操作Service实现
* @createDate 2022-11-11 21:22:24
*/
@Service
public class UserFilesServiceImpl extends ServiceImpl<UserFilesMapper, UserFiles>
    implements UserFilesService{
    @Autowired
    UserFilesDao userFilesDao;


    @Override
    public boolean uploadFiles(MultipartFile[] files, User user) throws IOException {
        //带uuid的文件名，以及真实的文件名字
        Map<String,String> fileMessage=new HashMap<>();
        List<String> uuidFilesName=new ArrayList<>();
        List<String> realFilesName=new ArrayList<>();
        if (files.length > 0) {
            String url = "D:\\A\\upload";
            File UploadPath = new File(url);
            //如果文件路径不存在，就创建一个路径
            if (!UploadPath.exists())
                UploadPath.mkdir();

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    //获取随机的uuid,以及真实的文件名
                    String uuid = UUID.randomUUID().toString();
                    String originalFilename = file.getOriginalFilename();
                    //获取文件后缀和前缀
                    String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String filePrefix =originalFilename.substring(0,originalFilename.lastIndexOf("."));
                   //实际保存的文件名
                    String savedFileName=uuid+fileSuffix;
                    //保存文件
                    String finalUrl = url + File.separator + savedFileName;
                    file.transferTo(new File(finalUrl));
                    //将文件信息添加到map集合
                    fileMessage.put(uuid,originalFilename);


                }

            }

        }
        else return false;

        //将信息保存到数据库
        boolean b = userFilesDao.addFiles(user, fileMessage);
        if (b) return true;
        return false;
    }
}




