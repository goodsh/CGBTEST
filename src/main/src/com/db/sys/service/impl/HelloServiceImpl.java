package com.db.sys.service.impl;

import com.db.sys.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String saHello(String msg) {
        System.out.println(msg);
        return msg;
    }
}
