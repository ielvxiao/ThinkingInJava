package 数组.数组为什么特殊;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class ContainerComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10]; //长度必须确定
        for (int i = 0; i <5 ; i++) {
            spheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            sphereList.add(new BerylliumSphere()); //之前已经到spheres[4]了。现在继续添加
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));
        int[] integers={0,1,2,3,4};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]); //数组采用[]来访问对象
        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4));
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));
    }
}
