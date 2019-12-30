package com.dz.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dz.api.model.DemoModel;
import com.dz.api.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference
    private DemoService demoService;

    @RequestMapping("test")
    public String test(String who){
        return demoService.sayHello(who);
    }

    @RequestMapping("get")
    public DemoModel getModel(){
        return demoService.getDemoModel();
    }
}
