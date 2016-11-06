package ClosureAndCallback;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh){callbackReference=cbh;}
    void go(){callbackReference.increment();}
}
