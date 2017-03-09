package thread.threadCooperation;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2017/3/9
 */
class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println(e + " Sender write exception");
        } catch (InterruptedException e) {
            System.out.println(e + "Sender sleep interrupted");
        }
    }
}

class Riceiver implements Runnable {
    private PipedReader in;

    public Riceiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read: " + (char)in.read() + " .");
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}
public class PipedIO {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Riceiver riceiver = new Riceiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(riceiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdown();
    }
}
