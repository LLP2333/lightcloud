package com.llp.lightcloud.service;

import com.llp.lightcloud.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author NASK
* @description 针对表【user】的数据库操作Service
* @createDate 2022-11-11 09:16:08
*/
public interface UserService extends IService<User> {

    //登录检测
    User  loginCheck(User user);
    //检查是否有该用户
    Boolean isNewUser(User user);
    //添加新用户

}
