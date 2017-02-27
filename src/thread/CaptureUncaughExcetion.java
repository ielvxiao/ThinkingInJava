package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by tiptop on 17-2-27.
 */

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by :" + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler()); //得到没有被抛出到异常
        throw new RuntimeException();
    }
}
/*
自定义以上异常到输出形式
 */
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thrad");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        //将每个创建到Thread上附着一个Thread.uncaughtExceptionHandler
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
public class CaptureUncaughExcetion {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
