package com.llp.lightcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llp.lightcloud.entity.UserFiles;
import com.llp.lightcloud.service.UserFilesService;
import com.llp.lightcloud.mapper.UserFilesMapper;
import org.springframework.stereotype.Service;

/**
* @author NASK
* @description 针对表【user_files】的数据库操作Service实现
* @createDate 2022-11-11 21:22:24
*/
@Service
public class UserFilesServiceImpl extends ServiceImpl<UserFilesMapper, UserFiles>
    implements UserFilesService{

}




