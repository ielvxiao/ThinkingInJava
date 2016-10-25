package classobject.pack1.类字面常量;

import java.util.Random;

/**
 * Created by Administrator on 2016/10/25.
 */
public class ClassInitialization {
    public static Random rand=new Random(47);


    public static void main(String[] args) throws Exception{
        //非静态域是不能在静态域中访问的
        Class initable=Initable.class;  //仅仅使用.class语法来获得对类的引用不会引发初始化
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFInal); //staticFianal 不需要对Initable进行初始化就可以读取。
       System.out.println(Initable2.staticNonFinal); //被强制初始化因为，staticNonFianl不是一个编译器常量
        System.out.println("After creating Initable3 ref");
        Class init=Class.forName("classobject.pack1.类字面常量.Initable3"); //要加上包名，为了产生Class引用，所以就要立刻进行初始化
        Initable2 i=new Initable2();
    }
    /*
    如果一个static域不是final的，那么对他访问的时候，总是要求在读取他之前，要先进行链接（为这个域分配空间）和初始化（初始化该存储空间）。
     */
}
