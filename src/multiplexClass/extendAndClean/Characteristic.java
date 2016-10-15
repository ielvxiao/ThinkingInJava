package multiplexClass.extendAndClean;

/**
 * Created by Administrator on 2016/10/15.
 */
public class Characteristic {
    private String s;
    Characteristic(String s){
        this.s=s;
        System.out.println("Creating Char="+s);
    }
    protected void dispsoe(){
        System.out.println("sipo++++++"+s);
    }
}
