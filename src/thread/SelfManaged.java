package thread;

/**
 * Created by tiptop on 17-2-24.
 */
public class SelfManaged implements Runnable {

    private int contDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + "(" + contDown + ")";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--contDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
