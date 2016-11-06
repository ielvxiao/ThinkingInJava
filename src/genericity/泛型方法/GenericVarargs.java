package genericity.泛型方法;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/10/28.
 * P635
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T...args){
        List<T> result=new ArrayList<T>();
        for (T item:args
             ) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls=makeList("A");   //makeList展示了和标准库中的import java.util.ArrayList()一样的功能
        System.out.println(ls);
        ls=makeList("a","b","c");
        System.out.println(ls);
    }
}