package multiplexClass.extendAndClean;

/**
 * Created by Administrator on 2016/10/15.
 */
public class test extends LivingCreature {
   public test(){
        System.out.println("我是默认构造器111");
    }
    private Characteristic a=new Characteristic("aaaaaaaaa"); //虽然在默认构造器后边，但是根据原则，还是要先调用成员的初始化方法
    public static void main(String[] args) {
        test test=new test();

    }
}
/*
output:
Creating Char=is alive
oher
LivingCreature
我是默认构造器111
///////////////////////////////
1调用基类构造器，这个步骤会不断的反复递归下去。
2按照声明顺序调用 成员的初始化方法。
3调用到处类构造器主体
 */
