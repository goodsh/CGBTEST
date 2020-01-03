package com.test.service;

import com.db.common.vo.DeptNode;
import com.db.sys.dao.SysDeptDao;
import com.db.sys.entity.SysDept;
import com.db.sys.service.SysDeptService;
import com.test.TestBase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestSysDeptService extends TestBase {
    @Test
    public void findObject(){
       SysDeptService sysDeptService= ctx.getBean(SysDeptService.class);
          List<Map<String,Object>> list =sysDeptService.deptfindObjects();
          System.out.println(list);
    }
     @Test
    public void deleptObject(){
        SysDeptService sysDeptService= ctx.getBean(SysDeptService.class);
         int list= sysDeptService.delObject(5);
        System.out.println(list);
    }
    @Test
    public void insertDeptObject(){
        SysDept sysDept =new SysDept();
        SysDeptDao sysDeptDao =
                ctx.getBean("sysDeptDao", SysDeptDao.class);
        int list=sysDeptDao.insertDeptObject(sysDept);
        System.out.println(list);

    }
    @Test
    public void findZtreeDeptNodes(){
        SysDeptService sysDeptService=ctx.getBean(SysDeptService.class);
                   List<DeptNode>list = sysDeptService.findZtreeDeptNodes();
                   System.out.println(list);

    }
    @Test
    public void updata(){
        SysDeptService sysDeptService=ctx.getBean(SysDeptService.class);
        SysDept sysDept= new SysDept();
        int list = sysDeptService.updataDeptObject(sysDept);
        System.out.println(list);

    }
}
