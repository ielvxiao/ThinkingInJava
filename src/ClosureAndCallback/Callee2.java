package ClosureAndCallback;

/**
 * Created by Administrator on 2016/10/20.
 */
public class Callee2 extends MyIncrement {
    private int i =0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    public class Closuer implements Incrementable {
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closuer();
    }
}
