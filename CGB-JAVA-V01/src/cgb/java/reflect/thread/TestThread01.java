package cgb.java.reflect.thread;

public class TestThread01 {

	static String content;
	public static void main(String[] args) 
	throws Exception{
		Thread t=new Thread(){
			@Override
			public void run() {//work thread
				content="hellworld";
			}//work thread 获取cpu以后
		};
		t.start();//main thread
		t.join();
		System.out.println(content.toUpperCase());
		
		
	}
}



