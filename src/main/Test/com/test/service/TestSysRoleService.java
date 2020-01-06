package com.test.service;

import com.db.common.vo.DeptNode;
import com.db.common.vo.PageObject;
import com.db.sys.dao.SysDeptDao;
import com.db.sys.entity.SysDept;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysDeptService;
import com.db.sys.service.SysRoleService;
import com.test.TestBase;
import com.test.dao.SysRoleMenu;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestSysRoleService extends TestBase {
    @Test
    public void findObject() {
        SysRoleService sysRoleService = ctx.getBean(SysRoleService.class);
        PageObject<SysRole> sd = sysRoleService.findPageObjects("admin", 3);
        System.out.println(sd);

    }

    @Test
    public void delect() {
        SysRoleService sysRoleService = ctx.getBean(SysRoleService.class);
        sysRoleService.deleteObject(5);

    }

    @Test
    public void saveObject() {
        SysRole sysRole = new SysRole();
        Integer[] a = new Integer[]{4,5};
        SysRoleService sysRoleService = ctx.getBean(SysRoleService.class);
         int s=sysRoleService.saveObject(sysRole,a);

    }


}
