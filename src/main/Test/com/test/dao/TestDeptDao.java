package com.test.dao;

import com.db.common.vo.DeptNode;
import com.db.sys.dao.SysDeptDao;
import com.db.sys.entity.SysDept;
import com.test.TestBase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestDeptDao extends TestBase {
    @Test
    public void testObjects() {
        SysDeptDao sysDeptDao =
                ctx.getBean("sysDeptDao", SysDeptDao.class);
        List<Map<String, Object>> list = sysDeptDao.findObjects();
        System.out.println(list);
    }

    @Test
    public void testgetChildCount() {
        SysDeptDao sysDeptDao =
                ctx.getBean("sysDeptDao", SysDeptDao.class);
        int list = sysDeptDao.getChildCount(5);
        System.out.println(list);
    }

    @Test
    public void insertDeptObject() {
        SysDept sysDept = new SysDept();
        SysDeptDao sysDeptDao =
                ctx.getBean("sysDeptDao", SysDeptDao.class);
        int list = sysDeptDao.insertDeptObject(sysDept);
        System.out.println(list);
    }

    @Test
    public void finddeptztreEmenunodesS() {
        SysDeptDao sysDeptDao =
                ctx.getBean("sysDeptDao", SysDeptDao.class);
        List<DeptNode> list = sysDeptDao.findZtreeDeptNodes();
        System.out.println(list);
    }

    @Test
    public void update() {
        SysDeptDao sysDeptDao =
                ctx.getBean("sysDeptDao", SysDeptDao.class);
             SysDept deptNode = new SysDept();
        int list = sysDeptDao.updataDeptObject(deptNode);
        System.out.println(list);
    }

}
