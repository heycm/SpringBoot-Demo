package com.dz.consumer.configuration;

import com.alibaba.dubbo.config.*;
import com.dz.api.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    // 提供方应用信息，用于计算依赖关系
    // <dubbo:application name="boot-user-service-provider"></dubbo:application>
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dz-springboot-consumer");
        return applicationConfig;
    }

    // 使用zookeeper广播注册中心暴露服务地址
    // <dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2188");
        return registryConfig;
    }

    // 用dubbo协议在20880端口暴露服务
    // <dubbo:protocol name="dubbo" port="20880"></dubbo:protocol>
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }
    /* 声明需要暴露的服务接口
        <dubbo:service interface="com.zang.gmall.service.UserService" ref="userServiceImpl01" timeout="1000" version="1.0.0">
            <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
        </dubbo:service>
     */
    @Bean
    public ReferenceConfig demoReferenceConfig(){
        ReferenceConfig<DemoService> serviceConfig = new ReferenceConfig<>();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setTimeout(3000);
        serviceConfig.setVersion("*");
        serviceConfig.setRetries(3);

        // 配置每一个method的信息
        List<MethodConfig> list = new ArrayList<>();

        MethodConfig sayHello = new MethodConfig();
        sayHello.setName("sayHello");
        list.add(sayHello);

        MethodConfig getDemoModel = new MethodConfig();
        sayHello.setName("getDemoModel");
        list.add(getDemoModel);

        // 将method的设置关联到service配置中
        serviceConfig.setMethods(list);

        return serviceConfig;
    }

    // 响应超时时间
    // <dubbo:provider timeout="5000"></dubbo:provider>
    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        consumerConfig.setRetries(3);
        return consumerConfig;
    }

    // 监控管理
    // <dubbo:monitor address="127.0.0.1:7010"></dubbo:monitor>
    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        // monitorConfig.setAddress("127.0.0.1:7010");
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
}
