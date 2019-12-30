package com.example.demo;

import com.example.demo.msg.MessageA;
import com.example.demo.msg.MessageB;
import com.example.demo.producer.MQProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MQProducer producer;

    @Test
    void testQueue(){
        // producer.sendStringQueue("stringQueue", "因为SpringRunner.class继承了SpringJUnit4ClassRunner.class且没有进行任何修改");
        // producer.sendStringQueue("stringQueue", "所以@RunWith(SpringRunner.class)基本等同于@RunWith(SpringJUnit4ClassRunner.class)");

        // HashMap<String, Object> map = new HashMap<>();
        // map.put("a", 1);
        // map.put("b", "中国");
        // map.put("c", true);
        // producer.sendMapQueue("mapQueue", map);

        MessageA messageA = new MessageA();
        messageA.setId(1);
        messageA.setContent("message context");
        // List list = new ArrayList();
        // list.add(messageA);
        // list.add(messageA);
        // producer.sendObjectQueue("objQueue", list);
        producer.sendObjectQueue("objQueue", messageA);
        // map.put("messageA", messageA);
        // producer.sendMapQueue("mapQueue", map);

    }

    @Test
    void testTopic(){
        // producer.sendStringTopic("stringTopic", "大家好");
        // producer.sendStringTopic("stringTopic", "我是广播器");


        MessageB messageB = new MessageB();
        MessageA messageA = new MessageA();
        messageA.setContent("我在里边");
        messageA.setId(2);
        messageB.setId(1);
        messageB.setContent(messageA);

        producer.sendObjectTopic("objTopic", messageB);

    }
}
