package cgb.java.reflect.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SysUser implements Externalizable{
	private Integer id;
    private Integer time;
    
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	/*//序列化定义的一种规范方法：用于对象序列化
	private void writeObject(ObjectOutputStream out)
	throws IOException{
		System.out.println("==writeObject==");
		//对数据加密
		id=id+1;
		//对对象执行序列化
		out.defaultWriteObject();
	}
	//序列化定义的一种规范方法：用于对象反序列化
	private void readObject(ObjectInputStream in)
	throws IOException,ClassNotFoundException{
		System.out.println("==readObject==");
		//执行反序列化
		in.defaultReadObject();
		//执行解密操作
		id=id-1;
	}*/
	/**将要序列化的内容在此方法中进行序列化*/
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeInt(time);
	}
	/**将需要反序列化的内容在此方法执行反序列化*/
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id=in.readInt();
		time = in.readInt();
	}
	

}