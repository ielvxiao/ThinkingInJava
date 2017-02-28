package thread.atomicclass;

import thread.EvenChecker;
import thread.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tiptop on 17-2-28.
 */
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
