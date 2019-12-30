package com.dz.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
    开启基于注解的dubbo功能
    也可以在配置配置文件dubbo.scan.base-package
    @EnableDubbo
    @ImportResources(locations = "provider.xml")
 */
@SpringBootApplication
@EnableDubbo
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}
