package com.test;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;


public class TestDataSource extends TestBase {
    @Test
    public void testDataSource()throws Exception{
        DataSource dataSource=
                ctx.getBean("dataSource",DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
