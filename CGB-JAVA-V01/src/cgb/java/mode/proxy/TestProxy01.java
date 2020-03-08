package cgb.java.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 目标接口:此接口提供了搜索服务的标准
 * @author ta
 */
interface SearchService{
	Object search(String key);
}
/**
 * 提供一种从文件中搜索相关内容的服务。
 * @author ta
 */
class FileSearchServiceImpl implements SearchService{
	@Override
	public Object search(String key) {
		//System.out.println("begin time:"+System.nanoTime());
		System.out.println("search from file");
		String result="file search result "+key;
		//System.out.println("end time:"+System.nanoTime());
	    return result;
	}//如何基于OCP(开闭原则)对方法进行功能扩展
}

class DatabaseSearchServiceImpl implements SearchService{

	@Override
	public Object search(String key) {
		System.out.println("search from database");
		String result="database search result "+key;
		return result;
	}
}

class SearchProxyFactory{
	 /**
	   * 为目标对象创建代理对象
	   * @param target 目标对象
	   * @return 代理对象
	   */
	  public Object newProxyInstance(Object target){
		  return Proxy.newProxyInstance(
				  target.getClass().getClassLoader(),//ClassLoader (为代理对象指定类加载器)
				  target.getClass().getInterfaces(),//interfaces (代理对象要实现的接口)
				  new SearchProxyHandler(target));//invocationHandler (处理器对象，负责帮代理对象处理业务)
	  }
}
class SearchProxyHandler implements InvocationHandler{
	  private Object target;
	  public SearchProxyHandler(Object target) {
	    this.target=target;
	  }
	  /**当执行代理对象的业务方法时，会执行此方法*/
	  @Override
	  public Object invoke(Object proxy, 
			  Method method,
			  Object[] args) throws Throwable {
		System.out.println("start time: "+System.nanoTime());
	    //执行目标对象target的method方法
	    Object result=method.invoke(target, args);
	    System.out.println("end time: "+System.nanoTime());
		return result;
	  }
}
public class TestProxy01 {
    public static void main(String[] args) {
        doMethod02();
    }
    public static void doMethod02(){
    	SearchService service=(SearchService)
    	new SearchProxyFactory()
    	.newProxyInstance(new DatabaseSearchServiceImpl());
    	System.out.println(service.getClass().getName());
        Object result=service.search("tmooc");
        System.out.println("result="+result);
    }
	private static void doMethod01() {
		//1.构建一个目标对象
		SearchService target=new FileSearchServiceImpl();
//		Object result=target.search("tedu");
//		System.out.println(result);
		//2.为目标对象创建一个代理对象
		//2.1 创建代理工厂
		SearchProxyFactory factory=new SearchProxyFactory();
		//2.2 创建代理对象
		SearchService proxy=(SearchService)
		factory.newProxyInstance(target);
		//System.out.println(proxy.getClass().getName());
	    //3.执行代理对象方法
		proxy.search("tedu");

	}
}




