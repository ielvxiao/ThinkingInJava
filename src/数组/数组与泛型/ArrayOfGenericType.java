package 数组.数组与泛型;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ArrayOfGenericType<T> {
  //  List[] array;
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
      //  array=new List[size]; //T类型不能直接被实例化,如果不是泛型类型则可以被实例化
        array = (T[]) new Object[size];  //会产生不受检查警告
    }
//    public <U> U[] makeArray(){
//        return new U[10];  //同样是不能直接被实例化
//    }

}
