package ClosureAndCallback;

/**
 * Created by Administrator on 2016/10/20.
 */
public class MyIncrement {
    public void increment(){
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi){mi.increment();}
}
