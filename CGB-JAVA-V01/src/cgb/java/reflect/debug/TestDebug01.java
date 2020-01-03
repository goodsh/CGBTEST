package cgb.java.reflect.debug;

public class TestDebug01 {

	static int doMethod01(int a){
		try{
		a++;
		}catch(Exception e){
		e.printStackTrace();	
		}finally{
		a++;
		}
		return a;
	}
	static int doMethod02(int a){
		try{
			a++;
			return a;//int temp=a;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			a++;
			System.out.println("a="+a);
		}
	}
	static int doMethod03(int a){
		try{
			a++;
			return a;//int temp=a;
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			a++;
			return a;
		}
	}
	public static void main(String[] args) {
		int r=doMethod02(10);
		System.out.println(r);
	}
}
