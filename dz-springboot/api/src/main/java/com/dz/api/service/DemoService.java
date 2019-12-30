package com.dz.api.service;

import com.dz.api.model.DemoModel;

public interface DemoService {
    String sayHello(String who);

    DemoModel getDemoModel();
}
