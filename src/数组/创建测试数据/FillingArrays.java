package 数组.创建测试数据;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/9.
 */
public class FillingArrays {
    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        String[] s = new String[size];
        double[] d = new double[size];
        Arrays.fill(s,"fill");
        Arrays.fill(d, 1.0);             //fill方法只能简单的用一个数值填充数组，作用不大
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(d));
    }
}
