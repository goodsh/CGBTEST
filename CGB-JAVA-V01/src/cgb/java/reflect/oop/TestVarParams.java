package cgb.java.reflect.oop;

public class TestVarParams {
    
	/*static void method(int a){}
	static void method(int a,int b){}
	static void method(int a,int b,int c){}*/
	
	/**
	 * 可变参数，可看成是一个特殊的数组
	 * @param a
	 */
	static void method(int... a){
		System.out.println(a.length);
	}
	
	public static void main(String[] args) {
		method();
		method(10);
		method(10,20);
		method(30,40,50);
		method(30,40,50,60);
	}
}
