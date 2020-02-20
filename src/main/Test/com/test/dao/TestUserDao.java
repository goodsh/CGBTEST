package com.test.dao;

import com.db.sys.dao.SysUserDao;
import com.db.sys.dao.SysUserRoleDao;
import com.db.sys.entity.SysLog;
import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptVo;
import com.test.TestBase;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestUserDao extends TestBase {
    @Test
    public void getObject(){
         SysUserDao sysUserDao=ctx.getBean("sysUserDao", SysUserDao.class);
         int a=sysUserDao.getUserCountByDeptId(2);
         System.out.println(a);
    }
    @Test
    public void findPageObjects(){
        SysUserDeptVo sysUserDeptVo = new SysUserDeptVo();
        SysUserDao sysUserDao=ctx.getBean("sysUserDao", SysUserDao.class);
       List<SysUserDeptVo> list= sysUserDao.findPageObjects("admin",0,3);

      for (SysUserDeptVo deptr : list){
          System.out.println(list);
      }


    }
    @Test
    public  void  validById(){
        Date date = new Date();
       SysUserDao sysUserDao= ctx.getBean("sysUserDao",SysUserDao.class);
       int a=sysUserDao.validById(5,1,"aaa");
       System.out.println(a);
    }
    @Test
    public void findObjectById(){
        SysUserDao sysUserDao= ctx.getBean("sysUserDao",SysUserDao.class);
        SysUserDeptVo a=sysUserDao.findObjectById(9);
         System.out.println(a);
    }
    @Test
   public void findRoleIdsByUserId(){
        SysUserRoleDao sysUserRoleDao =
               ctx.getBean("sysUserRoleDao",SysUserRoleDao.class);
    List<Integer> a=sysUserRoleDao.findRoleIdsByUserId(1);
       System.out.println(a);
   }
   @Test
    public void TestInsertObject(){
        SysUserDao sysUserDao=
               ctx.getBean("sysUserDao",SysUserDao.class);
       SysUser sysUser = new SysUser();
       sysUser.setUsername("Test2");
       sysUser.setEmail("555444@qq.com");
      int a= sysUserDao.insertObject(sysUser);
      System.out.println(a);
   }
   @Test
    public void findObjectName(){
       SysUserDao sysUserDao=
               ctx.getBean("sysUserDao",SysUserDao.class);
       Boolean sysUser=sysUserDao.findObjectName("655656454aa");
       System.out.println(sysUser);
   }
   @Test
    public void updateObject()
   {
       SysUserDao sysUserDao=
               ctx.getBean("sysUserDao",SysUserDao.class);
       SysUser sysUser = new SysUser();
       sysUser.setUsername("aasdasd");
       sysUser.setModifiedUser("admin");

       int a=sysUserDao.updateObject(sysUser);
       System.out.println(a);

   }
   @Test
    public void delectObjec(){
        SysUserDao sysUserDao= ctx.getBean("sysUserDao",SysUserDao.class);
       int a= sysUserDao.delectsObject(3);
       System.out.println(a);
   }
}
