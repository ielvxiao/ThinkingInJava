package multiplexClass.staticExtend;

/**
 * Created by Administrator on 2016/10/15.
 */
public class mainTest {
    public static void main(String[] args) {
        StaticSuper staticSuper=new StaticSub();
        System.out.println(staticSuper.dynamicGet());
        System.out.println(staticSuper.staticGet()); //某个方法是静态的，它的行为就不具有多态性
    }
}
