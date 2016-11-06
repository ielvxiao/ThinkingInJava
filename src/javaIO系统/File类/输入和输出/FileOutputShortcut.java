package javaIO系统.File类.输入和输出;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by Administrator on 2016/11/6.
 */
public class FileOutputShortcut {
    static String file = "D:\\ideaworkplace\\ThinkingInJava\\src\\javaIO系统\\File类\\输入和输出\\FileOutputShortcut.java";
    public static void main(String[] args) throws IOException{
        BufferedReader in =new BufferedReader(new StringReader(BufferedInputFile.read(file)));
        PrintWriter out=new PrintWriter(file);
        int lineCount=1;
        String s;
        while ((s=in.readLine())!=null){
            out.println(lineCount++ +": "+s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
