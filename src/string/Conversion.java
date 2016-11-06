package string;

import java.util.Formatter;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Conversion{
    public String abc(int id,int id1,String message){
        return String.format("(t%d, q%d) %s", id,id1,message);
    }
    public static void main(String[] args) {
        Formatter f=new Formatter(System.out);
        char u='a';
        System.out.println("u='a'"); // % 字符
        f.format("s: %s\n", u); // s String
       // f.format("s: %d\n", u); d 整数型
        f.format("s: %c\n", u); //c Unicode字符
        f.format("s: %b\n", u); //b Boolean值
     //   f.format("s: %f\n", u);//f 浮点数(十进制)
     //   f.format("s: %e\n", u); //e 浮点数（科学计数）
     //   f.format("s: %x\n", u);//x 整数（十六进制）
        f.format("s: %h\n", u);//h 散列值（十六进制）
        Conversion c=new Conversion();
        String s=c.abc(1,2,"three");
        System.out.println(s);
        System.out.println("-123".matches("-?\\d+")); //前边可能有一个负号，后边跟着一位或者多位数字
        System.out.println("5678".matches("-?\\d+")); //因为可能有也可能没有所以为true
        System.out.println("+110".matches("-?\\d+"));   //因为前边有正好所以为false
        System.out.println("+110".matches("(-|\\+)?\\d+")); // 前边是正好或者负号 或者两者都没有，因为后边有一个? true
        String str="Then, when you have found the shrubbery, you must "+"cut down the mightiest tree in the forest... "
                +"with...a herring!";
        System.out.println(str.replaceFirst("f\\w+","located")); //以f开头，后面跟着一个或多个字母，这个的替换为located
        System.out.println(str.replaceAll("shrubbery|tree|herring","banana"));
    }
}
