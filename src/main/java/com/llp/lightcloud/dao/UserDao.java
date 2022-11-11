package com.llp.lightcloud.dao;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author llp
 * {@code @date} 2022年11月11日19:49
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper userMapper;
    //获取登录的用户的详细信息
    public User loginCheck(User user)
    {
        String username = user.getUsername();
        String password = user.getPassword();
        User returnUser = null;
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            returnUser = userMapper.selectByUsernameAndPassword(username, password);
        }
        return returnUser;

    }

    //判断是否为新用户
    public boolean isNewUser(User user)
    {
     User checkUser=userMapper.selectByUsername(user.getUsername());
     //true表示没有注册过，false表示注册过
     if (checkUser==null)
         return true;
     return false;
    }
}
