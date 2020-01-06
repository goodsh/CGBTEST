package com.test.dao;

import com.db.sys.dao.SysRoleMenuDao;
import com.test.TestBase;
import org.junit.Test;

public class SysRoleMenu extends TestBase {
    @Test
    public void into(){

     SysRoleMenuDao sysRoleMenuDao = ctx.getBean("sysRoleMenuDao", SysRoleMenuDao.class);
             int[] arr =new int[]{1,21,11};
    // sysRoleMenuDao.insertObject(5,arr);
    }
}
