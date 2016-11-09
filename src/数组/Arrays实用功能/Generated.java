package 数组.Arrays实用功能;


import 容器深入理解.CollectionData;

/**
 * Created by Administrator on 2016/11/9.
 */
public class Generated {
    public static <T> T[] array(T[] a, Generator<T> gen){
        return new CollectionData<T>(gen,a.length).toArray(a);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size){
       T[] a=(T[]) java.lang.reflect.Array.newInstance(type,size);
        return new CollectionData<T>(gen,size).toArray(a);
    }
}
