package com.example.demo.customer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
public class TopicCustomerA {

    @JmsListener(destination="stringTopic", containerFactory="jmsListenerContainerTopic")
    public void receiveString(String msg){
        System.out.println("stringTopicA"+"收到广播消息："+msg);
    }

    // @JmsListener(destination="objTopic", containerFactory="jmsListenerContainerTopic")
    public void receiveObj(ObjectMessage obj) throws JMSException {
        System.out.println("objTopicA"+"收到广播消息："+obj.getObject());
    }
}
