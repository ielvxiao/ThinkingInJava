package thread.threadCooperation;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2017/3/9
 */
class Toast {
    public enum Status {DRY, BUTTERED, JAMMED}
    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }
    public void butter() {status = Status.BUTTERED;}
    public void jam() {status = Status.JAMMED;}
    public Status getStatus() {return status;}

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}

class TotastQueue extends LinkedBlockingDeque<Toast> {}

class Toaster implements Runnable {
    private TotastQueue totastQueue;
    private int count;
    private Random rand = new Random(47);

    public Toaster(TotastQueue totastQueue) {
        this.totastQueue = totastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                totastQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}

class Butterer implements Runnable {
    private TotastQueue dryQueue, butteredQueue;

    public Butterer(TotastQueue dryQueue, TotastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer off");
        }
        System.out.println("Butterer off");
    }
}

class Jammer implements Runnable {
    private TotastQueue butteredQueue, finishedQueue;

    public Jammer(TotastQueue butteredQueue, TotastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = butteredQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}

class Eater implements Runnable {
    private TotastQueue finishedQueue;
    private int count = 0;

    public Eater(TotastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                if (t.getId() != count ++ ||
                        t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>>Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater off");
        }
    }
}
public class TaostOmatic {
    public static void main(String[] args) throws Exception {
        TotastQueue dryQueue = new TotastQueue(),
                butteredQueue = new TotastQueue(),
                finishedQueue = new TotastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdown();
    }
}
