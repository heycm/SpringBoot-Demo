package com.example.demo.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.Map;

@Service
public class MQProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送字符消息
     * @param queueName 队列名称
     * @param message 消息
     */
    public void sendStringQueue(String queueName, String message){
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), message);
    }

    public void sendStringTopic(String topicName, String message){
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(topicName), message);
    }

    public void sendMapQueue(String queueName, Map<String, Object> map){
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), map);
    }

    /**
     * 发送对象消息
     * @param queueName 队列名称
     * @param obj 对象消息
     */
    public void sendSerializableQueue(String queueName, Serializable obj){
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), obj);
    }

    public void sendObjectQueue(String queueName, Object obj){
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), obj);
    }

    public void sendObjectTopic(String topicName, Object obj){
        this.jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(topicName), obj);
    }
}
