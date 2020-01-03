package com.test.dao;

import com.db.sys.dao.SysLogDao;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.entity.SysLog;
import com.test.TestBase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestSysLogDao extends TestBase {
    @Test
    public void testGetRowCount() {
        SysLogDao dao =
                ctx.getBean("sysLogDao", SysLogDao.class);

        int rowCount = dao.getRowCount("admin");
        System.out.println("rowConut" + rowCount);

    }

    @Test
    public void sysMenu() {
        SysMenuDao dao =
                ctx.getBean("sysMenuDao", SysMenuDao.class);

        List<Map<String,Object>> re= dao.findObjects();


        System.out.println("rowConut" +re);

    }

    @Test
    public void testDelect() {
        SysLogDao dao =
                ctx.getBean("sysLogDao", SysLogDao.class);

        int rowCount = dao.deleteObjects(1);
        System.out.println("rowConut" + rowCount);

    }

    @Test
    public void testPageObjects() {
        SysLogDao dao =
                ctx.getBean("sysLogDao", SysLogDao.class);

        List<SysLog> daoPageObjects = dao.findPageObjects
                ("admin", 0, 5);
        for (SysLog log : daoPageObjects) {
            System.out.println(daoPageObjects);
        }
    }

}
