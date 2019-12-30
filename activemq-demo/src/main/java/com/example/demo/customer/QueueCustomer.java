package com.example.demo.customer;

import com.alibaba.fastjson.JSON;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.util.Map;

@Component
public class QueueCustomer {

    // @JmsListener(destination="stringQueue", containerFactory="jmsListenerContainerQueue")
    public void receiveString(String msg){
        System.out.println("队列"+"stringQueue"+"收到字符消息："+msg);
    }

    // @JmsListener(destination="objQueue", containerFactory="jmsListenerContainerQueue")
    public void receiveObj(ObjectMessage obj) throws JMSException {
        System.out.println("队列"+"objQueue"+"收到对象消息："+obj.getObject());
    }

    // @JmsListener(destination="mapQueue", containerFactory="jmsListenerContainerQueue")
    public void receiveMap(Map<String, Object> map){
        System.out.println("队列"+"mapQueue"+"收到map消息："+map);
    }
}
