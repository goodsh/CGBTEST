package cgb.java.reflect.oop;

interface Male{
	
}
interface Female{
	
}
class Boy implements Male{//is a (继承，实现)
	//has a (以属性形式存在) 
	private Girl girl;
	public void doWork(){
		//在某个类的某个方法中使用了另一个类
		//Use a System class 
		System.out.println("do Coding");
	}
}
class Girl implements Female{
	
}

public class TestOOP01 {

	public static void main(String[] args) {
	    //Use a
		Boy boy=new Boy();
	    boy.doWork();
	}
}










