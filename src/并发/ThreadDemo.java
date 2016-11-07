package 并发;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/6.
 */
class MyThread implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("进入守护线程"+Thread.currentThread().getName());
            writeToFile();
            System.out.println("退出守护线程"+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeToFile() throws Exception{
        File file =new File("c:"+File.separator+"test.txt");
        OutputStream os = new FileOutputStream(file,true);
        int count = 0;
        while (count< 999){
            os.write(("\r\nword"+count).getBytes());
            System.out.println("守护线程"+Thread.currentThread().getName()+"向文件中写入了word"+count);
            Thread.sleep(1000);
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("进入主线程"+Thread.currentThread().getName());
        MyThread m = new MyThread();
        Thread t =new Thread(m);
        t.setDaemon(true);
        t.start();
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        System.out.println("退出主线程"+Thread.currentThread().getName());

    }
}
