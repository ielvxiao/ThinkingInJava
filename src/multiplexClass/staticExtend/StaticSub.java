package multiplexClass.staticExtend;

/**
 * Created by Administrator on 2016/10/15.
 */
public class StaticSub extends StaticSuper {
    @Override
    public String dynamicGet() {
        return "Deived dynamicGet";
    }
    public static String staticGet(){
        return "Drived staticGet";
    }
}
