package com.llp.lightcloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author llp
 * {@code @date} 2022年11月12日15:59
 * 设置全局的文件保存路径（必须进行配置）
 */
@Configuration
@ConfigurationProperties(prefix = "myfile")
public class SaveFilePathConfig {

    //上传的文件的文件路径
    String filepath;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
