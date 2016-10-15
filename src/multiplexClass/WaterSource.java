package multiplexClass;

/**
 * Created by Administrator on 2016/10/15.
 */
public class WaterSource {
    private String s;
    WaterSource(){
        System.out.println(" WaterSource()");
        s="Constructed";
    }

    @Override
    public String toString() {
        return s;
    }

}
