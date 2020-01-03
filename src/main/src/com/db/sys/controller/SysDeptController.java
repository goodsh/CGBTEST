package com.db.sys.controller;

import com.db.common.vo.DeptNode;
import com.db.common.vo.JsonResult;
import com.db.sys.entity.SysDept;
import com.db.sys.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dept/")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping("doMenuDeptEditUI")
    public String doMenuDeptEditUI(){
        return "sys/dept_edit";
    }

    @RequestMapping("doDeptListUI")
    public String doDeptListUI(){
        return "sys/dept_list";
    }
    @RequestMapping("doDeptObjects")
    @ResponseBody
    public JsonResult doDeptObjects(){
         List<Map<String,Object>> list= sysDeptService.deptfindObjects();
        return new JsonResult(list);
    }
    @RequestMapping("doDeptDelectObjects")
    @ResponseBody
    public JsonResult doDeptDelectObjects(Integer id){
         sysDeptService.delObject(id);
        return new JsonResult("删除成功");
    }

    /**
     *
     * 保存
     * @param sysDept
     * @return
     */
    @RequestMapping("doMenuinsertDeptUI")
    @ResponseBody
    public JsonResult domenuinsertDeptedituI(SysDept sysDept){
       int rowdes= sysDeptService.insertDeptObject(sysDept);
      return new JsonResult(rowdes);
    }
    @RequestMapping("doFindZtreeDeptNodes")
    @ResponseBody
    public JsonResult doFindZtreeDeptNodes(){
         List<DeptNode> list=sysDeptService.findZtreeDeptNodes();
         return new JsonResult(list);
    }
    @RequestMapping("doupdataObject")
    @ResponseBody
    public JsonResult doupdataObject(SysDept sysDept){
        int a=sysDeptService.updataDeptObject(sysDept);
        return new JsonResult(a);
    }
}
