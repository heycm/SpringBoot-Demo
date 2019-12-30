package com.dz.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dz.api.model.DemoModel;
import com.dz.api.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String s) {
        return s + " hello!";
    }

    @Override
    public DemoModel getDemoModel() {
        DemoModel demoModel = new DemoModel();
        demoModel.setId(1);
        demoModel.setName("zhangsan");
        return demoModel;
    }
}
