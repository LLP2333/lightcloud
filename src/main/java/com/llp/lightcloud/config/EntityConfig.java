package com.llp.lightcloud.config;

import com.llp.lightcloud.entity.User;
import com.llp.lightcloud.entity.UserFiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author llp
 * {@code @date} 2022年11月12日9:12
 */
@Configuration
public class EntityConfig {
    @Bean
    public User getUser()
    {
        return new User();
    }
    @Bean
    public UserFiles getUserFiles()
    {
        return new UserFiles();
    }

}
