package javaIO系统.File类.输入和输出;

import java.io.*;

/**
 * Created by Administrator on 2016/11/6.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream("data.txt"));  //DataOutSream用来输入数据
        out.writeDouble(3.1415926);
        out.writeUTF("That was pi");
        out.writeDouble(1.4143);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in =new DataInputStream(new FileInputStream("data.txt")); //DataInputStream用来恢复数据
        System.out.println(in.readDouble()); //只读一行切实double
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());  //如果我们用一个非java程序读取writeUTF()所写的字符串时，必须编写一些特殊代码才能正确的读取字符串。
    }
}
