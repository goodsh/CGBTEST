package com.db.sys.service.logingAspect;

public class LoggingAspect {
	 public void beforeMethod(){
		 System.out.println("method start");
	 }
	 public void afterMethod(){
		 System.out.println("method end");
	 }
}