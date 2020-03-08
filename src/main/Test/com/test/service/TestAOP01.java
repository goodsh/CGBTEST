package com.test.service;

import com.db.sys.service.HelloService;
import com.db.sys.service.impl.HelloServiceImpl;
import com.test.TestBase;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

public class TestAOP01 extends TestBase {
    @Test
    public void tesa(){
        HelloService helloService=
                ctx.getBean(HelloService.class);
        helloService.saHello("cgb1712");

    }

}
