package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by tiptop on 17-2-24.
 */
class InnerThread1 {
    private int countDon = 5;
    private Inner inner;
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDon == 0)
                        return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

        @Override
        public String toString() {
            return getName() + " : " + countDon;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (InterruptedException e ) {
                    System.out.println("sleep interrupted");
                }
            }
        };
        t.start();
    }
}

class InnerRunable1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner implements Runnable {
        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + " : " + countDown;
        }
    }

    public InnerRunable1(String name) {
        inner = new Inner(name);
    }
}

class InnerRunadble2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunadble2(String name) {
        t = new Thread(() -> {
            try {
            while (true) {
                System.out.println(this);
                if (--countDown ==0)
                    return;
                TimeUnit.MILLISECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
}, name);
        t.start();
    }
}

class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0)
                                return;
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("sleep interrupted");
                    }
                }

                @Override
                public String toString() {
                    return getName() + " : " + countDown;
                }
            };
            t.start();
        }
    }
}
public class  ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunable1("InnerRunable1");
        new InnerThread2("InnerThread2");
        new ThreadMethod("ThreadMethod").runTask();

    }
}
