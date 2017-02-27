package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tiptop on 17-2-24.
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " +this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("Interrrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactoty());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("all daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
