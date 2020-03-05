package com.db.sys.controller;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 日志页面
 * @author zhaofen
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

	/*@Autowired
	@Qualifier("sysLogService")
	public void setSysLogService(SysLogService aaa) {
		this.sysLogService = aaa;
	}*/


    @GetMapping("doLogListUI")
    public String doLogListUI(){
        return "sys/log_list";
    }
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(
            Integer...ids){
        System.out.println("sysLogService="+sysLogService.getClass().getName());
        int rows=sysLogService.deleteObjects(ids);
        return new JsonResult("delete ok,rows="+rows);
    }
    //http://localhost/CGB-DB-SYS-V2.01/
    //log/doFindPageObjects.do?pageCurrent=1
    @RequestMapping(value="doFindPageObjects",
            method={RequestMethod.POST,
                    RequestMethod.GET})
    @ResponseBody
    public JsonResult doFindPageObjects(
            Integer pageCurrent,
            String username){
        PageObject<SysLog> po=
                sysLogService.findPageObjects(
                        username,pageCurrent);
        return new JsonResult(po);
    }
    //了解
	/*@RequestMapping("doFindObjects")
	@ResponseBody
	public String doFindObjects(){
		return "{\"id\":1,\"name\":\"liumingxuan\"}";
	}*/
    //了解
    //jackson api
	/*@RequestMapping(value="doFindPageObjects",
			method={RequestMethod.POST,
					RequestMethod.GET},
			produces="application/json;charset=utf-8")
	@ResponseBody
	public String doFindPageObjects(
			Integer pageCurrent,
			String username) throws JsonProcessingException{
		PageObject<SysLog> po=
				sysLogService.findPageObjects(
						username,pageCurrent);
		JsonResult result= new JsonResult(po);

		//构建对象映射(此对象负责json串和java对象之间的映射)
		ObjectMapper om=new ObjectMapper();//jackson api提供
		//将对象转换为json格式的字符串。
		String str=om.writeValueAsString(result);
		return str;
	}//jackson api
*/




/*	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
		System.out.println("SysLogController.doHandleRuntimeException");
		return new JsonResult(e);
	}*/


}





