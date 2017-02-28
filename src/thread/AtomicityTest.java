package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tiptop on 17-2-28.
 * 尽管 return i确实时原子操作，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取。除此之外，由于i也不是volatile的，因此还存在
 * 可视性问题。getValue()和evenIncrement()必须时synchronized的。在诸如此类的情况下，只有并发专科才能进行优化。
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public int getValue() {return i;}
    private synchronized void evenIncrement() {i++; i++;}

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
