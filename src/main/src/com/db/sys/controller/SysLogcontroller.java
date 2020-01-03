package com.db.sys.controller;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志页面
 * @author zhaofen
 */
@Controller
@RequestMapping("/log/")
public class SysLogcontroller {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("doLogListUI")
    public String doLogListstUI(){
        return "sys/log_list";
    }
    @RequestMapping(value = "doFindPageObjects",
    method = {RequestMethod.POST,
            RequestMethod.GET})
    @ResponseBody
    public JsonResult doFindPageObjects(String username, Integer pageCurrent){
        PageObject<SysLog> pageObject=
                sysLogService.findPageObjects(username,pageCurrent);
        return new JsonResult(pageObject);

    }
    @RequestMapping(value = "doDeleteObjects",
    method = {RequestMethod.GET,
    RequestMethod.POST})
    @ResponseBody
    public JsonResult doDeleteObjects(Integer...ids){
        sysLogService.deleteObjects(ids);
        return new JsonResult("delect ok");
    }

   @ResponseBody
   @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandLeRuntimeException(RuntimeException e){
        System.out.println("SysLog出现错误");
        return new JsonResult(e);
    }


}
