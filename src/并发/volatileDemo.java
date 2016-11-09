package 并发;

/**
 * Created by Administrator on 2016/11/8.
 */
public class volatileDemo {
    private volatile int number=0;
    public int getNumber(){
        return this.number;
    }
    public void increa(){
        this.number++;
    }

    public static void main(String[] args) {
        final volatileDemo v = new volatileDemo();
        for (int i = 0; i <500 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    v.increa();
                }
            }).start();
        }
        //如果还有子线程在运行，则主线程让出CPU资源
        //直到子线程运行完，主线程才运行
while (Thread.activeCount()>1){
    Thread.yield();
}
        System.out.println("number:"+v.getNumber());
    }
}
