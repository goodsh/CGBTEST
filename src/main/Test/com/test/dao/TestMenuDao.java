package com.test.dao;

import com.db.common.vo.Node;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.entity.SysMenu;
import com.test.TestBase;
import org.junit.Test;

import java.util.List;

public class TestMenuDao extends TestBase {
    @Test
    public void testGteidd() {
        SysMenuDao sysMenuDao =
                ctx.getBean("sysMenuDao", SysMenuDao.class);
        int a = sysMenuDao.getChildCount(1);
        System.out.println(a);

    }

    @Test
    public void findZtreeMenuNodes() {
        SysMenuDao sysMenuDao =
                ctx.getBean("sysMenuDao", SysMenuDao.class);
        List<Node> list = sysMenuDao.findZtreeMenuNodes();
        System.out.println(list);
    }


    @Test
    public void testdeleteObject() {
        SysMenuDao sysMenuDao =
                ctx.getBean("sysMenuDao", SysMenuDao.class);
        int a = sysMenuDao.deleteObject(1);
        System.out.println(a);

    }

    @Test
    public void testinsertObject() {
        SysMenuDao sysMenuDao =
                ctx.getBean("sysMenuDao", SysMenuDao.class);
        SysMenu ed = new SysMenu();
        try {
            int updateObject = sysMenuDao.updateObject(ed);
            System.out.println(updateObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void tewsdMesda() {
        SysMenuDao sysMenuDao =
                ctx.getBean("sysMenuDao", SysMenuDao.class);
        Integer [] a = new Integer[]{24,25,8};
        a[0]=24;
        a[1]=8;
        List<String> ad =sysMenuDao.findPermissions(a);
        System.out.println(ad);

    }
}
