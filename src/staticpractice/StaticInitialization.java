package staticpractice;

import net.sf.json.JSONArray;

/**
 * Created by Administrator on 2016/9/20.
 * Thinking in java 5.7.2
 * 要执行main方法首先要要加载staticpractice类，然后其静态域table和cupboard被初始化，这将导致它们对应的类也被加载，并且由于它们也都是包含静态的BOWL对象，因此BOWL也被
 加载。这样，在这个特殊的程序中的所有类在MAIN（）开始之前都被加载了。
 */


public class StaticInitialization {
    public static void main(String[] args){
         System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }
    static Table table=new Table();
    static Cupboard cupboard=new Cupboard();
}

