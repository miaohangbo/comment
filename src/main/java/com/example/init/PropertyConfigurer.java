package com.example.init;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by beijing.com on 2017/12/8.
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static Logger logger = LoggerFactory.getLogger(PropertyConfigurer.class);

    private Properties props;       // 存取properties配置文件key-value结果

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties mergeProperties = super.mergeProperties();
        this.props = mergeProperties;
        //       this.props.put("live_dubbo_service_provider_host", ServerUtil.getALiIp());
        //logger.info("live_dubbo_service_provider_host是："+  ServerUtil.getALiIp());
        return props;
    }

    public String getProperty(String key){
        return this.props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.props.getProperty(key, defaultValue);
    }

    public Object setProperty(String key, String value) {
        return this.props.setProperty(key, value);
    }
}
