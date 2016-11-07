package 并发;

/**
 * Created by Administrator on 2016/11/6.
 */
public class TicketsThread {
    public class myThread extends Thread{
        private int ticketsCount=5;
        private String name;

        public myThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (ticketsCount>0){
                ticketsCount--;
                System.out.println(name+"卖了一张票，剩余票数为"+ticketsCount+"张");
            }
        }
    }
    public static void main(String[] args) {
        TicketsThread t = new TicketsThread();
                myThread m1 =t.new myThread("1窗口");
        myThread m2 =t.new myThread("2窗口");
        myThread m3 =t.new myThread("3窗口");
        m1.run();
        m2.run();
        m3.run();

    }
}
