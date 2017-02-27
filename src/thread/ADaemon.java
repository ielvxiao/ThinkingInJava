package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by tiptop on 17-2-24.
 */
class Test implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("String ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
}

public class ADaemon {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Test());
        t.setDaemon(true);
        t.start();
    }
}
