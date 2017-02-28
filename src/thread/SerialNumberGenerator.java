package thread;

/**
 * Created by tiptop on 17-2-28.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public synchronized static int nextSerialNumber() {
        return serialNumber++; //不是线程安全的。java递增操作不是原子性的，涉及到一个读一个写操作，即便时最简单的操作，也为产生线程问题留下了空间。
    }
}
