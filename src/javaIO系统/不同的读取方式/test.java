package javaIO系统.不同的读取方式;

import java.io.*;

/**
 * Created by Administrator on 2016/11/7.
 * .InputStream、OutputStream

 处理字节流的抽象类

 InputStream 是字节输入流的所有类的超类,一般我们使用它的子类,如FileInputStream等.

 OutputStream是字节输出流的所有类的超类,一般我们使用它的子类,如FileOutputStream等.



 2.InputStreamReader  OutputStreamWriter

 处理字符流的抽象类

 InputStreamReader 是字节流通向字符流的桥梁,它将字节流转换为字符流.

 OutputStreamWriter是字符流通向字节流的桥梁，它将字符流转换为字节流.



 3.BufferedReader BufferedWriter

 BufferedReader 由Reader类扩展而来，提供通用的缓冲方式文本读取，readLine读取一个文本行，

 从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取。

 BufferedWriter  由Writer 类扩展而来，提供通用的缓冲方式文本写入， newLine使用平台自己的行分隔符，

 将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
 */
public class test {
    /*
    InputStream能从來源处读取一個一個byte,
所以它是最低级的，
     */
    public static void testInputStream(File file){
        FileInputStream in = null;
        int i;
        try {
           in = new FileInputStream(file);
           while ((i=in.read()) != -1){
               System.out.println(i);
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
     InputStreamReader
 InputStreamReader封裝了InputStream在里头,
 它以较高级的方式,一次读取一个一个字符,
 下例是假设有一个编码为utf8的文档,
 其內容只有一个中文字 "陳"
     */
     public static void testInputStreamReader(File file){
    InputStreamReader in =null;
    int i;
    try {
        in=new InputStreamReader(new FileInputStream(file),"utf8");
        while ((i=in.read()) != -1){
            System.out.println((char) i);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    /*
    BufferedReader
BufferedReader则是比InputStreamReader更高级,
它封裝了StreamReader类,
一次读取取一行的字符
     */
    public static void testBufferedReader(File file){
        BufferedReader in =null;
        String line;
        try {
            in=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf8"));
            while ((line=in.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File file =new File("C:\\a.txt");
        testInputStream(file);
        System.out.println("=================================");
        testInputStreamReader(file);
        System.out.println("=================================");
        testBufferedReader(file);
    }
}
