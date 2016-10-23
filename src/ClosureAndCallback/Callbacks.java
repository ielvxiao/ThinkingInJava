package ClosureAndCallback;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Callbacks {
    public static void main(String[] args) {
        Calleel1 c1=new Calleel1();
        Callee2 c2=new Callee2();
        MyIncrement.f(c2);
//        Caller caller1=new Caller(c1);
//        Caller caller2=new Caller(c2.getCallbackReference());
//          caller1.go();
//          caller1.go();
//          caller2.go();
//          caller2.go();
    }
}
