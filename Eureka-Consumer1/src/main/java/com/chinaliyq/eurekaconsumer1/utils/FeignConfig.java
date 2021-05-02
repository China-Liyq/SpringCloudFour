package com.chinaliyq.eurekaconsumer1.utils;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liyq
 * @Description: SpringCloudFour
 * @Date: 2021/4/30 - 22:16
 * @Version: 1.0
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
