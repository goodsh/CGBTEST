package cgb.java.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 执行者对象，例如mybatis中executor
 */
interface Executor {
    /**
     * 用于执行业务的方法
     */
    void execute(String statement);
}
/**
 * Executor对象的默认实现
 */
class DefaultExecutor implements Executor {
    @Override
    public void execute(String statement) {
        System.out.println("execute " + statement);
        System.out.println("execute " + statement);
    }//OCP
}

/**
 * 创建一个工厂对象用于为目标对象创建代理对象
 */
class TargetProxyFactory {
    public static Object newProxy(Object target,Aspect aspect) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                //在这个位置写this这个类要实现一个接口 不写的话就要去new InvocationHandler
                new ProxyHandler(target ,aspect));
    }
}

class ProxyHandler implements InvocationHandler {
    private Object target;
    private Aspect aspect;


    public ProxyHandler(Object target, Aspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    /**
     * 处理业务调用的函数(此方法会在代理对象业务方法执行时调用)
     * 1)扩展业务(我们要扩展的功能)
     * 2)核心业务(目标对象方法的调用)
     *
     * @param proxy  指向代理对象
     * @param method 目标接口方法对象
     * @param args   方法执行时参数 是通过反射调用业务方法时候传递的参数
     */
    @Override
    public Object invoke(Object proxy,
                         Method method, Object[] args) throws Throwable {
        //----业务实现方式1
//		System.out.println("start:"+System.nanoTime());
//		Object result=method.invoke(target, args);
//		System.out.println("end:"+System.nanoTime());
//		return result;
        //----业务实现方式2
		JoinPoint jp=new JoinPoint(target, method, args);
		LogAspect logAspect=new LogAspect();
		Object result=logAspect.around(jp);
		return result;
        //----业务实现方法3
//        JoinPoint jp = new JoinPoint(target, method, args);
//        Object result = aspect.around(jp);
//        return result;
    }
}
class JoinPoint {//连接点(借助此对象封装方法信息)
    private Object target;
    private Method method;
    private Object[] args;

    public JoinPoint(Object target, Method method, Object[] args) {
        super();
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object process() throws Exception {
        return method.invoke(target, args);
    }
}

//定义一个切面接口
interface Aspect {
    Object around(JoinPoint jp) throws Exception;
}

class LogAspect implements Aspect {
    @Override
    public Object around(JoinPoint jp) throws Exception {
        System.out.println("start:" + System.nanoTime());
        Object result = jp.process();
        System.out.println("end:" + System.nanoTime());
        return result;
    }
}

class TransactionAspect implements Aspect {
    @Override
    public Object around(JoinPoint jp) throws Exception {
        System.out.println("begin transaction");
        //执行核心业务
        Object result = jp.process();
        System.out.println("commit transaction");
        return result;
    }
}

public class TestProxy03 {//JVM 

    static public void main(String[] args) {
        //1.目标对象
        Executor target = new DefaultExecutor();
        //2.为目标对象创建一个代理对象
        //2.1创建日志切面对象
        LogAspect aspect1 = new LogAspect();
        TransactionAspect aspect2 = new TransactionAspect();
        //创建代理工厂
        Executor proxy =
                (Executor) TargetProxyFactory.newProxy(target,aspect1);
        //3.调用业务方法
        proxy.execute("select statement ");
    }
}






