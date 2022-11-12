package com.llp.lightcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llp.lightcloud.config.SaveFilePathConfig;
import com.llp.lightcloud.dao.UserFilesDao;
import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import com.llp.lightcloud.mapper.UserFilesMapper;
import com.llp.lightcloud.service.UserFilesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * @author NASK
 * @description 针对表【user_files】的数据库操作Service实现
 * @createDate 2022-11-11 21:22:24
 */
@Service
@Slf4j
public class UserFilesServiceImpl extends ServiceImpl<UserFilesMapper, UserFiles>
        implements UserFilesService {
    @Autowired
    UserFilesDao userFilesDao;
    @Autowired
    SaveFilePathConfig saveFilePathConfig;


    @Override
    public boolean uploadFiles(MultipartFile[] files, User user) throws IOException {
        //带uuid的文件名，以及真实的文件名字
        Map<String, String> fileMessage = new HashMap<>();
        List<String> uuidFilesName = new ArrayList<>();
        List<String> realFilesName = new ArrayList<>();
        if (files.length > 0) {
            File UploadPath = new File(saveFilePathConfig.getFilepath());
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
                    String filePrefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
                    //实际保存的文件名
                    String savedFileName = uuid + fileSuffix;
                    //保存文件
                    String finalUrl = saveFilePathConfig.getFilepath() + File.separator + savedFileName;
                    file.transferTo(new File(finalUrl));
                    //将文件信息添加到map集合
                    fileMessage.put(savedFileName, originalFilename);


                }

            }

        } else return false;

        //将信息保存到数据库
        boolean b = userFilesDao.addFiles(user, fileMessage);
        if (b) return true;
        return false;
    }

    @Override
    public List<UserFiles> getUserFileList(User user) {
        String username = user.getUsername();
        List<UserFiles> list = userFilesDao.getUserFileList(username);
        return list;
    }

    @Override
    public byte[] getDownloadFile(String id)  {

        UserFiles userFiles = getById(id);
        String filename = userFiles.getFilename();
        String  finalPath=saveFilePathConfig.getFilepath()+File.separator+filename;
       byte[] bytes=null;
        try {
          InputStream  is = new FileInputStream(new File(finalPath));
            bytes=new byte[is.available()];
            is.read(bytes);
        } catch (FileNotFoundException e) {
            log.info("文件未找到异常");
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.info("获取文件字节流异常");
            throw new RuntimeException(e);
        }

        return bytes;
    }
}




