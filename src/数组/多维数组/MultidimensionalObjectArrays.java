package 数组.多维数组;

import 数组.数组为什么特殊.BerylliumSphere;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/2.
 */
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        BerylliumSphere[][] spheres = {
                {new BerylliumSphere(),new BerylliumSphere()},
                {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()},
                {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere(),
                        new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()}
        };
        System.out.println(Arrays.deepToString(spheres));
    }
}
