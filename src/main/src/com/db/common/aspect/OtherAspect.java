package com.db.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(2)
@Aspect
@Service
public class OtherAspect {
    @Pointcut("bean(sysUserServiceImpl)")
    public void doPointCut(){}
    /**增强功能：前置通知(业务方法执行之前执行)*/

   @Before("doPointCut()")
    public void before(){
        System.out.println("@Before");
   }
    /**增强功能：最终通知(业务方法执行最后执行，
     *无论业务方法是否执行成功，此功能都要执行)*/
   @After("doPointCut()")
   public void affterMetHod(){
       System.out.println( "@After");
   }
   /** 返回通知 (@AfterReturning) 方法return之后执行*/
   @AfterReturning("doPointCut()")
    public void returnMetHod(){
    System.out.println(" @AfterReturning");
   }
   /**异常通知 (@AfterThrowing) 方法出现异常之后执行 */
   @AfterThrowing("doPointCut()")
    public void throwMethod(){
     System.out.println("@AfterThrowing");
   }
   @Around("doPointCut()")
   public Object arroundMethod(ProceedingJoinPoint jp) throws Throwable {
       try {
           System.out.println("@Around before");
           Object result=jp.proceed();
           System.out.println("@Around  AfterReturning");
           return result;
       } catch (Exception e){
      System.out.println("@Around  AfterThrowing");
      throw e;

       }finally {
       System.out.println("@Around After");
       }
   }

}
