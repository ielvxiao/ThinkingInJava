package javaIO系统.File类.输入和输出;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException{
        BufferedReader in =new BufferedReader(new FileReader(filename));
        String s;
        StringBuffer sb=new StringBuffer();
        while ((s=in.readLine())!=null){
            sb.append(s+"\n");   //sb用来积累文件的全部内容(必须添加换行符，因为readline（）把换行符都删除了)
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        System.out.println(read("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\BufferedInputFile.java"));
        System.out.println("-----------------------------");
        StringReader stringReader = new StringReader(read("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\BufferedInputFile.java"));
        int c;
        while ((c=stringReader.read()) !=-1){
            System.out.println((char) c);//read()是以int形式返回下一个字节，因此必须类型转换为CHAR才能正确打印
        }
    }
}
