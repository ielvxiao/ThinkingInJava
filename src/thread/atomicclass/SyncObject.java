package thread.atomicclass;

/**
 * @author Administrator
 * @date 2017/3/8
 */
class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for (int i = 0; i < 50; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void go() {
        synchronized (syncObject) {
            for (int i = 0; i < 50; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

/**
 * DualSync.f()在this同步，而go()在syncObject上同步，这两个同步是相互独立的。所以他们是同时运行的不会被另一个方法同步而被阻塞。
 */
public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread(()->ds.f()).start();
        ds.go();
    }
}
