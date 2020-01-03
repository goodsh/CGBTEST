package cgb.java.reflect.oop;

import java.lang.reflect.Constructor;

class Point{//如何告诉spring这个类要交给spring管理(两种方式)
	private int x;
	private int y;
    {//构建对象时执行(实例代码块)
		x=10;
		y=20;
	}
    public Point(){}
	public Point(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
class Framework{
	public Object newInstance(Class<?> cls)
	throws Exception{
		//1.基于类对象获取构造方法对象
		Constructor<?> con=cls.getDeclaredConstructor();
		//2.设置构造方法对象可访问(有些构造方法可能是私有)
		con.setAccessible(true);
		//3.基于构造方法对象构建类的实例
		return con.newInstance();
	}
	public Object newInstance(Class<?> cls,
			Class<?>[] parameterTypes)
			throws Exception{
	    return null;
	}
	//.....
	
}
public class TestReflect01 {
	public static void main(String[] args)throws Exception {
		//类对象(字节码对象)
		Class<?> c1=Point.class;
		Class<?> c2=
		Class.forName("cgb.java.reflect.Point");
		//类的对象(类的实例)
		Point p1=new Point();
		Point p2=new Point(10,20);
		//通过类的实例获取类对象(字节码对象)
		Class<?> c3=p1.getClass();
		Class<?> c4=p2.getClass();
		
		System.out.println(p1==p2);//false
		System.out.println(c1==c2);//true
		System.out.println(c3==c4);//true
		System.out.println(c1==c3);//true
		//基于类对象构建类的对象
		Framework fk=new Framework();
		Object obj=fk.newInstance(c2);
		System.out.println(obj);
		
		
	}
}












