package 数组.数组为什么特殊;

/**
 * Created by Administrator on 2016/10/28.
 */
public class BerylliumSphere {
    private static long counter;
    private final long id=counter++;

    @Override
    public String toString() {
        return "Sphere"+id;
    }
}
