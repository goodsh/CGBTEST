package com.db.sys.controller;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @RequestMapping("doUserListUI")
    public String doUser(){
        return "sys/user_list";
    }
    @RequestMapping("doUserEdit")
    public String doUserEdit(){
        return "sys/user_edit";
    }

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(
            String username,Integer pageCurrent){
        PageObject<SysUserDeptVo> pageObject=
                sysUserService.findPageObjects(username,
                        pageCurrent);
        return new JsonResult(pageObject);
    }
    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        Map<String,Object> sa=sysUserService.findObjectById(id);
        return new JsonResult(sa);
    }
    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(
            SysUser entity,Integer[] roleIds){
        sysUserService.updataObject(entity,
                roleIds);
        return new JsonResult("修改成功");
    }

    @PostMapping("doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer id ,Integer valid){
        sysUserService.validById(id,valid,"admin");
        return new JsonResult("更新成功");
    }
    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysUser sysUser,Integer [] roleIds){
        sysUserService.saveObject(sysUser,roleIds);
        return new JsonResult("保存成功");
    }
    @RequestMapping("delectObject")
    @ResponseBody
    public JsonResult delectObject(Integer id,SysUser sysUser){
        sysUserService.delectObject(id,sysUser);
        return new JsonResult("删除成功");
    }

}
