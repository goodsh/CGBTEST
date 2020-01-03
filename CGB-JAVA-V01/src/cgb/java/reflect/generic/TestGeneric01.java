package cgb.java.reflect.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 何为泛型？
 * 1)JDK1.5以后推出一种的新的参数化类型。
 * 2)通常可以理解为一种编译时类型，在运行时无效。
 * 3)类似生活中的标签(例如商品的标签)
 * <p>
 * 为何使用泛型？
 * 1)约束类中属性类型，方法参数类型，方法返回值类型
 * 2)提高运行时性能。
 * List s=new ArrayList();
 * s.add(100);
 * Integer o=(Integer)s.get(0);
 * <p>
 * 泛型的应用方式分析？
 * 1)泛型类: 类名<泛型> 例如 class PageObject<T>{}
 * 2)泛型方法: <泛型>方法返回值类型
 * @ZHAOFEN
 */
class Container<T> {//泛型类
    private Object array[];

    public Container(int cap) {
        array = new Object[cap];
    }

    public void add(T t) {


    }

    @SuppressWarnings("unchecked")
    public T get() {
        return (T) array[0];

    }
}

class ContainerUtil {
    //泛型方法
    public static <E>List<E> sort(List<E> list){
        return null;
    }
    //泛型方法
    public static <T> T get(List<T> list){
      if(list!=null && list.size()>0) {
          return list.get(0);
      }
          return null;
    }
}
public class TestGeneric01 {
    public static void main(String[] args) {
        Container<Integer> d = new Container<Integer>(6);
        d.add(100);
        Integer i = d.get();
        Container<?> d2 = new Container<>(10);


        List<String> list = new ArrayList<>();
                list.add("E");
                list.add("S");
                ContainerUtil.sort(list);
        String a=ContainerUtil.get(list);



    }

}
