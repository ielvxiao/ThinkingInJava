package javaIO系统.File类.输入和输出;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/6.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException{
        DataInputStream dataInputStream =new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\TestEOF.java")));
        while (dataInputStream.available() != 0){
            System.out.println((char) dataInputStream.readByte());
        }
    }
}
