package thread.atomicclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @date 2017/3/6
 */
class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

    abstract class PairManager {
        AtomicInteger checkCounter = new AtomicInteger(0);
        protected Pair p = new Pair();
        /**
         * 线程安全：多个线程操作容器的时候，互相之间不会带来意想不到的影响；

         有些容器是线程安全的（Vector,ConcurrentLinkedQueue等），有些则不是（list等），利用类似 private static List<Task> taskQueue = Collections.synchronizedList(new LinkedList<Task>());的方法可以得到本身不是线程安全的容易的线程安全的状态，但是要注意的是线程安全仅仅指的是如果直接使用它提供的函数，比如：queue.add(obj); 或者 queue.poll(obj);，这样我们自己不需要做任何同步。
         但如果是非原子操作，比如：
         1. if(!queue.isEmpty()) {
         2.    queue.poll(obj);
         3. }
         我们很难保证，在调用了isEmpty()之后，poll()之前，这个queue没有被其他线程修改。
         所以对于这种情况，我们还是需要自己同步：
         1. synchronized(queue) {
         2.     if(!queue.isEmpty()) {
         3.        queue.poll(obj);
         4.     }
         5. }
         对于Collections.synchronizedList(new LinkedList<Task>())，
         在返回的列表上进行迭代时，用户必须手工在返回的列表上进行同步：
         List list = Collections.synchronizedList(new ArrayList());
         ...
         synchronized(list) {
         Iterator i = list.iterator(); // Must be in synchronized block
         while (i.hasNext())
         foo(i.next());
         }


         不遵从此建议将导致无法确定的行为。

         */
        private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
        public synchronized Pair getPair() {
            return new Pair(p.getX(), p.getY());
        }
        //线程安全。因为68行这个list是同步的
        protected void store(Pair p) {
            storage.add(p);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException ignore) {
            }
        }
        public abstract void increment();
    }

    class PairManager1 extends PairManager {
        //abstract方法必须重写
        @Override
        public void increment() {
            p.incrementX();
            p.incrementY();
            store(getPair());
        }
    }

    class PairManager2 extends PairManager {
        @Override
        public void increment() {
            Pair temp;
            synchronized (this) {
                p.incrementX();
                p.incrementY();
                temp = getPair();
            }
            store(temp);
        }
    }

    class PairManipulator implements Runnable {
        private PairManager pm;

        public PairManipulator(PairManager pm) {
            this.pm = pm;
        }

        @Override
        public void run() {
            while (true)
                pm.increment();
        }

        @Override
        public String toString() {
            return "Pair: " + pm.getPair() + " CheckCounter = " + pm.checkCounter.get();
        }
    }

    class PairChecker implements Runnable {
        private PairManager pm;

        public PairChecker(PairManager pm) {
            this.pm = pm;
        }

        @Override
        public void run() {
            while (true) {
                pm.checkCounter.get();
                pm.getPair().checkState();
            }
        }
    }

public class CriticalSection {
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2);
        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2" + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager
                pm1 = new PairManager1(),
                pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}
