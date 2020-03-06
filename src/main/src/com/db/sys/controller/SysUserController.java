package com.db.sys.controller;


import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String doUser() {
        return "sys/user_list";
    }

    @RequestMapping("doUserEdit")
    public String doUserEdit() {
        return "sys/user_edit";
    }

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(
            String username, Integer pageCurrent) {
        PageObject<SysUserDeptVo> pageObject =
                sysUserService.findPageObjects(username,
                        pageCurrent);
        return new JsonResult(pageObject);
    }

    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id) {
        Map<String, Object> sa = sysUserService.findObjectById(id);
        return new JsonResult(sa);
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(
            SysUser entity, Integer[] roleIds) {
        sysUserService.updataObject(entity,
                roleIds);
        return new JsonResult("修改成功");
    }

    @PostMapping("doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer id, Integer valid) {
        //此登录用户是在认证时传入的一个身份，
        //可以看ShiroUserRealm中的AuthenticationInfo方法
        SysUser user=(SysUser)
        SecurityUtils.getSubject().getPrincipal();

        sysUserService.validById(id, valid, user.getUsername());
        return new JsonResult("更新成功");
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysUser sysUser, Integer[] roleIds) {
        sysUserService.saveObject(sysUser, roleIds);
        return new JsonResult("保存成功");
    }

    @RequestMapping("delectObject")
    @ResponseBody
    public JsonResult delectObject(Integer id, SysUser sysUser) {
        sysUserService.delectObject(id, sysUser);
        return new JsonResult("删除成功");
    }

    @RequestMapping("doLogin")
    @ResponseBody
    public JsonResult doLogin(String username, String password) {
        //1.获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //2.通过Subject提交用户信息,交给shiro框架进行认证操作
        //2.1对用户进行封装
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        //分析:
        //1)token会传给shiro的SecurityManager
        //2)SecurityManager将token传递给认证管理器
        //3)认证管理器会将token传递给realm
        return new JsonResult("登陆成功");
    }

}
