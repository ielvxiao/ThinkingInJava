package 数组.数组与泛型;

import 数组.数组为什么特殊.BerylliumSphere;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls=(List<String>[]) la;  //一旦拥有了对List<String>[]的引用，你就回看到你将得到某些编译器检查。
        ls[0]=new ArrayList<String>();
        Object[] objects = ls;//List<String>[]也是Object[]利用这一点。
        objects[1] = new ArrayList<Integer>(); //可以将一个ArrayList<Integer>赋值到你的数组中
        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i <spheres.length ; i++) {
            spheres[i] = new ArrayList<BerylliumSphere>();
        }
    }
}
