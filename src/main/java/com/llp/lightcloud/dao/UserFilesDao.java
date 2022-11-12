package com.llp.lightcloud.dao;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import com.llp.lightcloud.mapper.UserFilesMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author llp
 * {@code @date} 2022年11月12日9:08
 */

@Repository
@Slf4j
public class UserFilesDao {
    @Autowired
    UserFilesMapper userFilesMapper;


    public boolean addFiles(User user, Map<String,String> fileMessage)
    {
        UserFiles userFiles=new UserFiles();
        int result=0;
        if(fileMessage.size()>0)
        {
            String username = user.getUsername();
            Iterator<Map.Entry<String, String>> iterator = fileMessage.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<String, String> entry = iterator.next();

                userFiles.setUsername(username);
                userFiles.setFilename(entry.getKey());
                userFiles.setFilepath(entry.getValue());
                userFiles.setIsdelete(0);
                result = userFilesMapper.insert(userFiles);

            }

        }
        log.info("插入的文件数量{}",result);
        //如果信息都插入成功，返回true
        if (result==fileMessage.size())
        {
         return true;
        }
        else return false;

    }

}
