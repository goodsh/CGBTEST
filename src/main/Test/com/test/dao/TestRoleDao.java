package com.test.dao;

import com.db.common.vo.DeptNode;
import com.db.sys.dao.SysDeptDao;
import com.db.sys.dao.SysRoleDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.entity.SysDept;
import com.db.sys.entity.SysRole;
import com.db.sys.vo.SysRoleMenuVo;
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
    public void testFindObjectByid(){
        SysRole a = new SysRole();
       SysRoleMenuDao sysRoleDao= ctx.getBean("sysRoleMenuDao",SysRoleMenuDao.class);
        // List<Integer> svo =sysRoleDao.findMenuIdsByRoleId(46);

    }
    @Test
    public void testdeleteObject(){
        SysRoleDao sysRoleDao= ctx.getBean("sysRoleDao",SysRoleDao.class);
        int a =sysRoleDao.deleteObject(48);
        System.out.println(a);
    }
    @Test
    public void testfindObjectById(){

        SysRoleDao sysRoleDao= ctx.getBean("sysRoleDao",SysRoleDao.class);
       SysRoleMenuVo svo =sysRoleDao.findObjectById(47);
        System.out.println(svo);
    }
}
