package cgb.java.reflect.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestSerializable02 {
	public static void main(String[] args)throws Exception {
	//1.构建一个文件对象?
	File file=new File("data.dat");
	//2.将日志对象序列化到文件
	doMethod01(file);
	//3.从文件中读取对象
	doMethod02(file);
	}
	public static void doMethod02(File file)throws Exception{
		//1.构建流对象，读取文件
		ObjectInputStream in=
		new ObjectInputStream(new FileInputStream(file));
		//2.读取对象
		SysUser log=(SysUser)in.readObject();
		System.out.println(log.getId());
		System.out.println(log.getTime());
		//3.释放资源
		in.close();
	}
    //序列化//提取方法 alt+shift+m
	private static void doMethod01(File file) throws IOException, FileNotFoundException {
		//2.1 构建日志对象
		SysUser log=new SysUser();
		log.setId(100);
		log.setTime(1000);
		//2.2 构建对象流对象
		ObjectOutputStream out=
		new ObjectOutputStream(new FileOutputStream(file));
		//2.3执行对象的序列化
		out.writeObject(log);
		//2.4.释放资源	
		out.close();
		System.out.println("序列化ok");
	}
}
