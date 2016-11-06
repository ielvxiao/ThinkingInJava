package javaIO系统.File类.目录实用工具;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Administrator on 2016/11/4.
 * 这是一个灵巧的打印机类
 */
public class PPrint {
    public static String pformat(Collection<?> c){
        if (c.size()==0){
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem: c
             ) {
            if (c.size() != 1){
                result.append("\n ");
            }
            result.append(elem);
        }
        if (c.size() !=1){
            result.append("\n ");
        }
        result.append("]");
        return result.toString();
    }
    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }
    public static void  pprint(Object[] c){
        System.out.println(pformat(Arrays.asList(c)));
    }
}
