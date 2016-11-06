package multiplexClass.onlineExample;

/**
 * Created by Administrator on 2016/10/15.
 */
public class B extends A {
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}
