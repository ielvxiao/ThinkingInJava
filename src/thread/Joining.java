package thread;

/**
 * Created by tiptop on 17-2-24.
 */
class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted. "
                    + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + "has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}


public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleeper = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("grumpy", 1500);
        Joiner
                dopey = new Joiner("dopey", sleeper),
                doc = new Joiner("doc", grumpy);
        grumpy.interrupt();
    }

}
