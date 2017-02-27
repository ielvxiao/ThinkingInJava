package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tiptop on 17-2-27.
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("Exception has been handled");  //还是无法捕获从
        }
    }
}
