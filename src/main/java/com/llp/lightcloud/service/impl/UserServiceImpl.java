package com.llp.lightcloud.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llp.lightcloud.dao.UserDao;
import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.service.UserService;
import com.llp.lightcloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author NASK
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-11 09:16:08
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public User loginCheck(User user) {
        //根据用户名和密码获取user,为null说明用户不存在
        User resultUser = userDao.loginCheck(user);
        return resultUser;
    }

    @Override
    public Boolean isNewUser(User user) {
        boolean result = userDao.isNewUser(user);
        return result;
    }
    //添加新用户,先进行是否新用户的判断，再执行添加功能
    @Override
    public boolean saveOrUpdate(User user) {
        Boolean result = isNewUser(user);
        if(result)
        {
            return super.saveOrUpdate(user);
        }
        return false;

    }
}




