package com.test.dao;

import com.db.sys.dao.SysUserDao;
import com.test.TestBase;
import org.junit.Test;

public class TestUserDao extends TestBase {
    @Test
    public void getObject(){
         SysUserDao sysUserDao=ctx.getBean("sysUserDao", SysUserDao.class);
         int a=sysUserDao.getUserCountByDeptId(2);
         System.out.println(a);
    }
}
