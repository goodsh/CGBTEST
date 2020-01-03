package com.db.common.web;

import com.db.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**全局异常处理类
 * @author zhaofen*/
@ControllerAdvice
public class GlobalExceptionHandler {
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
