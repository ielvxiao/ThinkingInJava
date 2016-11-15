package 容器深入理解.填充容器;

/**
 * Created by Administrator on 2016/11/14.
 */
public class StringAddress {
    private String s;
    public StringAddress(String s){this.s = s;}

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
