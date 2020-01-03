package com.test.service;

import com.db.common.vo.Node;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.db.sys.service.SysMenuService;
import com.test.TestBase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestSysMenuService extends TestBase{
    @Test
    public void testDeleteObjects(){
        SysLogService logService=
                ctx.getBean("sysLogService",
                        SysLogService.class);
        int rows=logService.deleteObjects(80,81);
        System.out.println("rows "+rows);
    }
    @Test
    public void testDeleteObject(){
       SysMenuService sysMenuService= ctx.getBean(SysMenuService.class);
         int a=sysMenuService.deleteObject(8);
        System.out.println("rows "+a);

    }
    @Test
    public void testfindZtreeMenuNodes(){
        SysMenuService sysMenuService= ctx.getBean(SysMenuService.class);
       List<Node> list= sysMenuService.findZtreeMenuNodes();
        System.out.println("list "+list);
    }


}









