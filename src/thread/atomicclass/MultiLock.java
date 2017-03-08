package thread.atomicclass;

/**
 * @author Administrator
 * @date 2017/3/8
 */
public class MultiLock {
    /**
     * f1和f2互相调用。这样不会产生冲突。而且可以保证任务.
     * @param count
     */
    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        final MultiLock multiLock = new MultiLock();
        new Thread(() -> multiLock.f2(10)).start();
    }
}
