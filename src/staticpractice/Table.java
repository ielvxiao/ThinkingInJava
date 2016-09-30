package staticpractice;

/**
 * Created by Administrator on 2016/9/30.
 */
public class Table {
    static Bowl bowl1=new Bowl(1);
    Table(){
        System.out.println("Table()");
        bowl2.f1(1);
    }
    void f2(int mark){
        System.out.println("f2("+mark+")");

    }
    static Bowl bowl2=new Bowl(2);
}
