package genericity.擦除的神秘之处;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/10/28.
 * P649
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        String parametersType=Arrays.toString(new ArrayList<String>().getClass().getTypeParameters());
        String s=new ArrayList<String>().getClass().getName();
        System.out.println(c1); //
        System.out.println(c1==c2); //由上面可以知道他们都是 Arraylist 程序会认为它们是相同的类型
        System.out.println(s);
        System.out.println(parametersType); //返回参数是占位符。。。。。。并不能返回我们想要的类型。
    }
}
/*
java泛型是使用擦除来实现的，这意味着当你在使用泛型时，任何具体的类型信息都被擦除了，你唯一知道的就是你在使用一个对象，因此List<String>和List<Integer>在运行时事实上是相同的类型
这两种类型都被擦除程了它们的“原生”类型就是list。
 */