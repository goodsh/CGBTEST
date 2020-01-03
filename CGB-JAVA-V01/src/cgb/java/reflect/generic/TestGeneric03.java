package cgb.java.reflect.generic;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class TestGeneric03 {
	public static void main(String[] args)
	throws Exception{
		List<String> list=new ArrayList<>();
		list.add("100");
		list.add("200");
		//list.add(300);
		//基于反射技术将300存入list集合
		//1.获取类对象
		Class<?> c=list.getClass();
		//2.获取类中的add方法对象
		Method m=
		c.getDeclaredMethod("add",Object.class);    
		//3.执行方法对象
		//执行list对象的add方法，将300存入集合
		m.invoke(list, 300);
		System.out.println(list);
	}
}









