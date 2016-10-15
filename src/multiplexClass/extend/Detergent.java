package multiplexClass.extend;

/**
 * Created by Administrator on 2016/10/15.
 */
public class Detergent extends Cleanser {
    //Change method
    public void scrub(){
        append(" Detergent.scrub()");
        super.scrub(); //调用基类的方法。
    }
    //add method
    public void foam(){append("foam()");}

    public static void main(String[] args) {
        Detergent x=new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class;");
        Cleanser.main(args);
    }
}
