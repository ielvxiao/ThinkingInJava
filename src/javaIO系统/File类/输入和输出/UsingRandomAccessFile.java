package javaIO系统.File类.输入和输出;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2016/11/6.
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    static void display() throws IOException{
        RandomAccessFile rf= new RandomAccessFile(file,"r");
        for (int i = 0; i <7 ; i++) {
            System.out.println("value"+i+rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException{
        RandomAccessFile rf = new RandomAccessFile(file,"rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i*1.1414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf=new RandomAccessFile(file,"rw");
        rf.seek(5*8); //double总是8字节长，所以为了用seek()查找第5个双精度值，你只需要5*8来产生查找的位置
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
