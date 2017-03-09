package thread.atomicclass;

import jdk.nashorn.internal.ir.IfNode;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2017/3/8
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeddsCleanup " + id);
    }

    public void cleandup() {
        System.out.println("Cleaning up" + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //1
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    //2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("Sleeping");
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                        n2.cleandup();
                    }
                } finally {
                    n1.cleandup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }
    }
}

public class InterruptingIdiom {
    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
//            System.out.println("usage: java InterruptingIdiom delay-inmS");
//            System.exit(1);
//        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(10);
        t.interrupt();
    }
}
