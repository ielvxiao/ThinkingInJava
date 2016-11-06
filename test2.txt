package javaIO系统.File类.输入和输出;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/11/6.
 * getAbsoluteFile()返回的是一个File类对象，这个File对象表示是当前File对象的绝对路径名形式
 getAbsolutePath()返回的是一个字符串，这个字符串就是当前File对象的绝对路径名的字符串形式
 */
public class TextFile extends ArrayList<String> {
    //read方法
    public static String read(String fileName){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s=in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    //write方法
    public static void write(String fileName, String text){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.println(text);
            } finally {
             out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //用特点的分隔符分割文件然后读取它
    public TextFile(String fileName, String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }
    public void write(String fileName){
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item: this
                     ) {
                    out.println(item);
                }
            } finally {
out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public TextFile(String fileName){
        this(fileName,"\n");
    }

    public static void main(String[] args) {
        String file = read("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\TextFile.java");
        write("test.txt",file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<String>(new TextFile("D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\TextFile.java","\\W+"));
        System.out.println(words.headSet("a"));
    }
}
