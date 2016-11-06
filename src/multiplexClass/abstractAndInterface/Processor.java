package multiplexClass.abstractAndInterface;

/**
 * Created by Administrator on 2016/10/18.
 */
public class Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){return input;}

    public static void main(String[] args) {
        Processor processor=new Processor();
        System.out.println(processor.name().toString());
    }
}
