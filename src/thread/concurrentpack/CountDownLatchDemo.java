package thread.concurrentpack;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2017/3/10
 */
class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter ++;
    //Random函数中的种子，种子相同时生成的随机数也相同。
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }
    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + "completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {

        }
    }
}

class WaittingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaittingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d" + id);
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for" + this);
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
    }
}
public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i <10 ; i++) {
            exec.execute(new WaittingTask(latch));
        }

        for (int i = 0; i < SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        exec.shutdown();
    }
}
