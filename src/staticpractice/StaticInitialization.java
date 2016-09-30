package staticpractice;

import net.sf.json.JSONArray;

/**
 * Created by Administrator on 2016/9/20.
 * Thinking in java 5.7.2
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
