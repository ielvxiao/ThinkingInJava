package thread.threadCooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2017/3/9
 */
class Car {
//    private boolean wax0n = false;
//    public synchronized void waxed() {
//        wax0n = true;
//        notifyAll();
//    }
//    public synchronized void buffed() {
//        wax0n = false;
//        notifyAll();
//    }
//    public synchronized void waitForWaxing() throws InterruptedException {
//        while (wax0n == false)
//            wait();
//    }
//    public synchronized void waitForBuffing() throws InterruptedException {
//        while (wax0n == true)
//            wait();
//    }
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean wax0n = false;

    public void waxed() {
        lock.lock();
        try {
            wax0n = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public synchronized void buffed() {
        lock.lock();
        try {
            wax0n = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (wax0n == false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}

class Wax0n implements Runnable {
//    private Car car;
//
//    public Wax0n(Car car) {
//        this.car = car;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (!Thread.interrupted()) {
//                System.out.println("Wax 0n!");
//                TimeUnit.MILLISECONDS.sleep(200);
//                car.waxed();
//                car.waitForBuffing();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Exiting via interrupt");
//        }
//        System.out.println("Ending Wax 0n task");
//    }
private Car car;

    public Wax0n(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class Wax0ff implements Runnable {
//    private Car car;
//
//    public Wax0ff(Car car) {
//        this.car = car;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (!Thread.interrupted()) {
//                car.waitForWaxing();
//                System.out.println("Wax 0ff!");
//                TimeUnit.MILLISECONDS.sleep(200);
//                car.buffed();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Exiting via interrupt");
//        }
//        System.out.println("Ending wax 0ff task");
//    }
private Car car;

    public Wax0ff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax 0ff!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending wax 0ff task");
    }
}

public class Wax0Matic {
//    public static void main(String[] args) throws Exception {
//        Car car = new Car();
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new Wax0ff(car));
//        exec.execute(new Wax0n(car));
//        TimeUnit.SECONDS.sleep(1);
//        exec.shutdown();
//    }
public static void main(String[] args) throws Exception {
    Car car = new Car();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new Wax0ff(car));
    exec.execute(new Wax0n(car));
    TimeUnit.SECONDS.sleep(5);
    exec.shutdown();
}
}
