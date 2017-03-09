package thread.threadCooperation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2017/3/9
 */
class Blocker {
    private String name;

    public Blocker(String name) {
        this.name = name;
    }

    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(name + " waitingCall().interrupted");
            }
        } catch (InterruptedException e) {

        }
    }
    synchronized void prod() {notify();}
    synchronized void prodAll() {notifyAll();}
}

class Task implements Runnable {
    static Blocker blocker = new Blocker("Task");
    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker("Task2");
    @Override
    public void run() {
        blocker.waitingCall();
    }
}
public class NotifyVsNotfiyAll {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod) {
                    System.out.println("notify()");
                    Task2.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll() ");
                    Task2.blocker.prod();
                    prod = true;
                }
            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("task.blocker.prodAll");
        Task.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shutting down");
        exec.shutdown();
    }
}
