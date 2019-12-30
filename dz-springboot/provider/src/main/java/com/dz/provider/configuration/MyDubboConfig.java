package com.dz.provider.configuration;

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
        applicationConfig.setName("dz-springboot-provider");
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
    public ServiceConfig demoServiceConfig(DemoService demoService){
        ServiceConfig<DemoService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(demoService);
        serviceConfig.setTimeout(3000);
        serviceConfig.setRetries(3);
        serviceConfig.setVersion("1.0.0");

        // 配置每一个method的信息
        List<MethodConfig> list = new ArrayList<>();

        MethodConfig sayHello = new MethodConfig();
        sayHello.setName("sayHello");
        sayHello.setRetries(2);
        sayHello.setTimeout(3000);
        list.add(sayHello);

        MethodConfig getDemoModel = new MethodConfig();
        getDemoModel.setName("getDemoModel");
        getDemoModel.setRetries(2);
        getDemoModel.setTimeout(3000);
        list.add(getDemoModel);

        // 将method的设置关联到service配置中
        serviceConfig.setMethods(list);

        return serviceConfig;
    }

    // 响应超时时间
    // <dubbo:provider timeout="5000"></dubbo:provider>
    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(5000);
        providerConfig.setRetries(3);
        return providerConfig;
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
