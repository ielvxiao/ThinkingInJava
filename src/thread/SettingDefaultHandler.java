package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tiptop on 17-2-27.
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        //设置一个默认的未捕获异常处理器。
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> System.out.println("caught :" + e));
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
