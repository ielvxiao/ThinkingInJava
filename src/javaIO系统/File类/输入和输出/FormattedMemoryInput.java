package javaIO系统.File类.输入和输出;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/6.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException{
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\BufferedInputFile.java").getBytes()));
            while (true){
                System.out.println((char) in.readByte());
            }
        } catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}
