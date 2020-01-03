package com.test.service;

import org.junit.Test;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.test.TestBase;
public class TestSysLogService extends TestBase{
    @Test
    public void testDeleteObjects(){
        SysLogService logService=
                ctx.getBean("sysLogService",
                        SysLogService.class);
        int rows=logService.deleteObjects(80,81);
        System.out.println("rows "+rows);

    }
    @Test
    public void testFindPageObjects(){
        SysLogService logService=
                ctx.getBean("sysLogService",
                        SysLogService.class);
        PageObject<SysLog> po=
                logService.findPageObjects(null,
                        1);
        System.out.println(po.getRowCount());
        System.out.println(po.getPageSize());
        System.out.println(po.getPageCount());
    }
}









