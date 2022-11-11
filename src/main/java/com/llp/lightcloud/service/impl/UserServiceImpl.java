package com.llp.lightcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.service.UserService;
import com.llp.lightcloud.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author NASK
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-11 09:16:08
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




