package com.test.dao;

import com.db.common.vo.DeptNode;
import com.db.sys.dao.SysDeptDao;
import com.db.sys.dao.SysRoleDao;
import com.db.sys.entity.SysDept;
import com.db.sys.entity.SysRole;
import com.test.TestBase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestRoleDao extends TestBase {
    @Test
    public void findPageObjects(){
       SysRoleDao sysRoleDao= ctx.getBean("sysRoleDao", SysRoleDao.class);
       List<SysRole> sd=sysRoleDao.findPageObjects("admin",5,6);
       System.out.println(sd);
    }
    @Test
    public void insertObject(){
        SysRole a = new SysRole();
       SysRoleDao sysRoleDao= ctx.getBean("sysRoleDao",SysRoleDao.class);
       sysRoleDao.insertObject(a);
    }




}
