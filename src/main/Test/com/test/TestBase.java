package com.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 测试基类
 * @author ta
 */
public class TestBase {
    protected ClassPathXmlApplicationContext ctx;
    /**借助此方法初始化容器
     * @Before 会在@Test之前执行
     * */
    @Before
    public void init() {
        ctx=new ClassPathXmlApplicationContext("spring-configs.xml");
    }
    /**借助此方法销毁容器
     * @After 会在@Test之后执行*/
    @After
    public void destory() {
        ctx.close();
    }
}





