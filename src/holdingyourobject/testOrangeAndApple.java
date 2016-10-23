package holdingyourobject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class testOrangeAndApple {
    public static void main(String[] args) {
        ArrayList<Apple> apples=new ArrayList<Apple>();
        for (int i=0;i<3;i++){
            apples.add(new Apple());
             apples.add(new ExtendsApple()); //向上转型也可以加入
          //  apples.add(new Orange()); 尖括号里指定了类型参数所以不能插入Orange对象 报的错误是编译期错误，而不是运行时错误

        }
        for (Apple c: apples
             ) {
            System.out.println(c.id());
        }
    }


}
