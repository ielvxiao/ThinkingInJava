package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tiptop on 17-2-23.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
