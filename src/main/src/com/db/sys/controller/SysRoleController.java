package com.db.sys.controller;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysRole;
import com.db.sys.service.SysRoleService;
import com.db.sys.vo.SysRoleMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.ObjectName;
import java.util.Map;

@Controller
@RequestMapping("/role/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @RequestMapping("doRoleListUI")
    public String doRoleListUI(){
        return "sys/role_list";
    }
    @RequestMapping("doRoleEditUI")
    public String doRoleEditUI(){
        return "sys/role_edit";
    }
    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){
          PageObject<SysRole> pageObject =sysRoleService.findPageObjects(name,pageCurrent);
          return new JsonResult(pageObject);
    }
    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        sysRoleService.deleteObject(id);
        return new JsonResult("删除成功");
    }
    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysRole entity,Integer[] menuIds){
     sysRoleService.saveObject(entity,menuIds);
     return new JsonResult("保存成功");
    }
    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        Map<String,Object> map=
                sysRoleService.findObjectById(id);
        return new JsonResult(map);
    }

}
