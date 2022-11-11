package com.llp.lightcloud.mapper;
import java.util.List;

import com.llp.lightcloud.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author NASK
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-11-11 09:16:08
* @Entity com.llp.lightcloud.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    //通过用户名的密码获取user的完整信息
    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    //通过用户名获取用户
    User selectByUsername(@Param("username") String username);
}




