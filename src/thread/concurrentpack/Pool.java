package thread.concurrentpack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Administrator
 * @date 2017/3/10
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private Semaphore availabel;
    private volatile boolean[] checkedOut;
    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        availabel = new Semaphore(size, true);
        for (int i = 0; i <size ; i++) {
            try {
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }
    public synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1)
            return false;
        if (checkedOut[index]) {
            checkedOut[index] =false;
            return true;
        }
        return false;
    }
    public void checkIn(T x) {
        if (releaseItem(x)) {
            availabel.release();
        }
    }
    public T checkOut() throws InterruptedException {
        availabel.acquire();
        return getItem();
    }
}
