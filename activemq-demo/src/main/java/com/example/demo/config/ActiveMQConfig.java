package com.example.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
public class ActiveMQConfig {

    /**
     * 从yml配置文件读参数
     */
    @Value("${spring.activemq.broker-url}")
    private String brokerURL;

    @Value("${spring.activemq.user}")
    private String userName;

    @Value("${spring.activemq.password}")
    private String password;

    /**
     * 1.配置activemq连接工厂
     * @return ActiveMQConnectionFactory
     */
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(userName, password, brokerURL);
        // 使用ObjectMessage传输对象必备包
        factory.setTrustAllPackages(true);
        return factory;
    }

    /**
     * 2.配置生产-消费模式监听器
     * @param activeMQConnectionFactory 连接工厂
     * @return JmsListenerContainerFactory
     */
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerQueue(ConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    /**
     * 3.配置发布-订阅模式监听器
     * @param activeMQConnectionFactory 连接工厂
     * @return JmsListenerContainerFactory
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        bean.setPubSubDomain(true); // 开启P/S模式
        return bean;
    }
}
