package com.db.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在此控制层对象中提供一些对外的页面呈现。
 * @author ta
 */
@Controller
@RequestMapping("/")
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";
		//返回值会给dispatcherServlet
		//dispatcherServlet会将此值交给视图解析器
		//视图解析器会对此值进行解析获取view

		//Prefix=/WEB-INF/pages/
		//Suffix=.html
		//view=/WEB-INF/pages/starter.html
	}
	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
}








