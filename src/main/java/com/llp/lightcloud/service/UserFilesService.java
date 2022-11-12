package com.llp.lightcloud.service;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author NASK
 * @description 针对表【user_files】的数据库操作Service
 * @createDate 2022-11-11 21:22:24
 */
public interface UserFilesService extends IService<UserFiles> {
    //上传文件服务
    boolean uploadFiles(MultipartFile[] files, User user) throws IOException;
    //获取用户的文件列表
    List<UserFiles> getUserFileList(User user);

    byte[] getDownloadFile(String id) throws IOException;
}
