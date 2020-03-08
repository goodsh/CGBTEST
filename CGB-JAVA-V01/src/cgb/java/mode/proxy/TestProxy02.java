package cgb.java.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟mybatis
 * 搜索服务的数据层对象
 * @author ta
 */
interface SearchDao{
     Object searcha(String key);
}
//模拟mybatis中的sqlSession
interface SqlSession{
	 <T>T getMapper(Class<T> targetClass);
}
/**模拟SqlSession对象实现*/
class DefaultSqlSession implements SqlSession{
    //创建接口类型的代理对象
	@Override
	public <T>T getMapper(Class<T> targetClass) {
		//此方法中如何产生代理对象
		//1.创建代理工厂对象
		DaoProxyFactory factory=new DaoProxyFactory();
		//2.基于工厂创建代理对象
		return factory.newInstance(targetClass,this);
	}
}
//代理对象处理器(负责处理具体业务)
class DaoProxyHandler implements InvocationHandler{
	private Class<?> targetClass;
	private SqlSession sqlSession;
	public DaoProxyHandler(Class<?> targetClass,
			SqlSession sqlSession) {
		this.targetClass=targetClass;
		this.sqlSession=sqlSession;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke -->"+method.getName());
		String namespace=targetClass.getName();
		String elementId=method.getName();
		String statement=namespace+"."+elementId;
		System.out.println("statement="+statement);
		//sqlSession.selectList(statement,args)
		//...
		return null;
	}
}
//产生代理对象工厂
class DaoProxyFactory{
	//创建代理对象
	@SuppressWarnings("unchecked")
	public <T>T newInstance(Class<T> targetClass,
			    SqlSession sqlSession){
		 return (T)Proxy.newProxyInstance(
				 targetClass.getClassLoader(),//ClassLoader
				 new Class[]{targetClass},//interfaces
				 new DaoProxyHandler(targetClass,sqlSession));//InvocationHandler 
	}
}
public class TestProxy02 {
	public static void main(String[] args) {
	   SqlSession session=new DefaultSqlSession();
	   SearchDao dao=session.getMapper(SearchDao.class);
	   System.out.println("11:"+dao.getClass().getName());
	   dao.searcha("tedus");
	}
}








