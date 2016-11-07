package 并发;

/**
 * Created by Administrator on 2016/11/6.
 */
class MyRunable implements Runnable{
    private int ticketsCount=5;
    @Override
    public void run() {
        while (ticketsCount>0){
            ticketsCount--;
            System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数为"+ticketsCount+"张");
        }
    }
}
public class TicketsRunable {

    public static void main(String[] args) {
        MyRunable mr = new MyRunable();
        Thread m1 = new Thread(mr,"窗口1");
        Thread m2 = new Thread(mr,"窗口2");
        Thread m3 = new Thread(mr,"窗口3");
        m1.start();
        m2.start();
        m3.start();
    }
}
