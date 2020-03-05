package com.db.common.web;

import com.db.common.vo.JsonResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**全局异常处理类
 * @author zhaofen*/
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doShirExcepion(ShiroException e){
		e.printStackTrace();

		JsonResult r = new JsonResult();
		r.setState(0);
		if (e instanceof UnknownAccountException){
			r.setMessage("账户不存在");
		}   else if (e instanceof LockedAccountException){
            r.setMessage("账户被锁定");
		} else if (e instanceof IncorrectCredentialsException){
           r.setMessage("密码不对");
		} else if (e instanceof AuthorizationException) {
			r.setMessage("没有权限");
		} else {
			r.setMessage(e.getMessage());
		}
		return r;
	}
	/**
	     JDK中的自带的日志API
	 */
	@ExceptionHandler(RuntimeException.class)
    @ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
		/**
		 * //也可以写日志
		 */
		e.printStackTrace();
		/**
		 * //封装异常信息
		 */
		return new JsonResult(e);
	}
}
