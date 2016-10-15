package multiplexClass;

/**
 * Created by Administrator on 2016/10/15.
 */
public class SprinklerSystem {
    private String value1, value2, value3, value4;
    private WaterSource source=new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "value1 = "+value1+" "+
                "value2 = "+value2+" "+
                "value3 = "+value3+" "+
                "value4 = "+value4+"\n"+
                "i = "+i+" "+"f = "+f+" "+
                "source = "+source+" ";
    }
    public static void main(String[] args){
        SprinklerSystem sprinklerSystem=new SprinklerSystem();
        System.out.println(sprinklerSystem);
        /*
        output:
        WaterSource()
value1 = null value2 = null value3 = null value4 = null
i = 0 f = 0.0 source = Constructed
类中域为积分吧、类型时能够自动被初始化为零。但是对象引用会被初始化为NULL，并且如果你试图为它们调用任何方法，都会得到一个异常--运行时错误
在不抛出异常的情况下仍旧可以打印一个NULL引用。
         */
    }
}
