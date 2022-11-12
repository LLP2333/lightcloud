package com.llp.lightcloud;

import com.llp.lightcloud.dao.UserFilesDao;
import com.llp.lightcloud.entity.UserFiles;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author llp
 * {@code @date} 2022年11月12日11:30
 */
@SpringBootTest
@Slf4j
public class TestUserFilesDao {
    @Autowired
    UserFilesDao userFilesDao;

    //测试用户列表功能
    @Test
    void testUserFileList()
    {
        List<UserFiles> result = userFilesDao.getUserFileList("llp");
        result.forEach(System.out::println);

    }
}
