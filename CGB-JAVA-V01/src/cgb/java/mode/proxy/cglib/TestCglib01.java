package cgb.java.mode.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//使用CGLIB为此对象产生代理对象时，这个类不能使用final的
class LogService {
    public void delete() {
        System.out.println("delete");
    }

    public static class TestCglib01 {
        public static void main(String[] args) {
            //1.目标对象(没有实现接口)
            LogService tada = new LogService();
            //2.为目标对象创建代理对象
            //2.1创建Enhancer对象，通过此对象为目标对象创建代理对象
            Enhancer ed = new Enhancer();//相当于jdk中Proxy
            ed.setCallback(new MethodInterceptor() {//相当于handler
                @Override
                public Object intercept(
                        Object obj,//????? //代理对象
                        Method method, //???? 目标对象方法
                        Object[] args, //目标对象参数+。
                        MethodProxy proxy)//代理对象里面方法
                        throws Throwable {
                    //扩展业务
                    System.out.println("intercept");
                    //目标业务 调用目标对象（父类对象）方法
                    Object result = proxy.invokeSuper(obj, args);
                    return result;
                }
            });
            //2.2设置代理对象的父类类型
            ed.setSuperclass(tada.getClass());
            //2.3创建代理对象
            LogService proxy = (LogService) ed.create();
            //2.3调用代理对象方法
            proxy.delete();
        }
    }
}
