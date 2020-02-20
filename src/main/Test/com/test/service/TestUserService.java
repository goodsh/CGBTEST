package com.test.service;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptVo;
import com.test.TestBase;
import org.junit.Test;

import java.util.Map;

public class TestUserService extends TestBase {
    @Test
    public void testFegeObject(){
          SysUserService sa=ctx.getBean(SysUserService.class);
          PageObject<SysUserDeptVo> list =sa.findPageObjects("admin",1);
          System.out.println(list);
    }
    @Test
    public void validById(){
        SysUserService sa=ctx.getBean(SysUserService.class);
        int a=sa.validById(1,1,"admin");
        System.out.println(a);
    }
    @Test
    public void saveObject(){
        SysUserService sa=ctx.getBean(SysUserService.class);
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
         sysUser.setPassword("adasda");
         sysUser.setEmail("7545454@qq.com");
        sysUser.setSalt("das54d5as4d54as5d4");
        sysUser.setMobile("aasdasd");
        sysUser.setValid(0);
        sysUser.setDeptId(5);
        sysUser.setModifiedUser("admin");
        Integer [] a= new Integer[(5)];

       int b = sa.saveObject(sysUser,a);
       System.out.println(b);

    }
    @Test
    public void teStfindObjectById(){
        SysUserService sa=ctx.getBean(SysUserService.class);
       Map<String,Object> ad = sa.findObjectById(19);
       System.out.println(ad);
    }
    @Test
    public void testUpdea(){
        SysUser sysUser = new SysUser();
        Integer [] abab= new Integer[5];

        sysUser.setUsername("aaa");

        SysUserService a=ctx.getBean(SysUserService.class);

        a.updataObject(sysUser,abab);

    }
    @Test
    public void delectObject(){
        SysUserService a=ctx.getBean(SysUserService.class);
        SysUser sysUser = new SysUser();
        sysUser.setId(5);

    }

}
