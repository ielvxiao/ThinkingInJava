package 数组.数组是第一级对象;

import 数组.数组为什么特殊.BerylliumSphere;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/10/28.
 */
public class ArrayOptions {
    public static void main(String[] args) {
        //Arrays of objects
        BerylliumSphere[] a;  //尚未被初始化的局部变量
        BerylliumSphere[] b=new BerylliumSphere[5];
        System.out.println("b:"+ Arrays.toString(b)); //所有对象默认全为null，如果是几本类型则按照基本类型的默认值来处理
        BerylliumSphere[] c=new BerylliumSphere[4];
        for (int i = 0; i <c.length ; i++) {
            if (c[i]==null){
                c[i]=new BerylliumSphere();
            }
        }
        BerylliumSphere[] d={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        a=new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        System.out.println("a.length="+a.length);   //length是数组对象的一部分（事实上是唯一一个可以访问的字段和方法）
        System.out.println("b.length="+b.length);
        System.out.println("c.length="+c.length);
        a=d;           //隐式地使用NEW在堆中创建，就像数组C一样。将d数组的引用指向堆中的同一个数组对象。
        System.out.println("a.length="+a.length);

        //Arrays of primitives
        int[] e;
        int[] f=new int[5]; //
        System.out.println("f: "+Arrays.toString(f));
        int[] g=new int[4];
        for (int i = 0; i <g.length ; i++) {
            g[i]=i*i;
        }
        int[] h={11,47,93};
        System.out.println("f.length="+f.length);
        System.out.println("g.length="+g.length);
        System.out.println("h.length="+h.length);
        e=h;
        System.out.println("e.length="+e.length);
        e = new int[]{1,2};
        System.out.println("e.length="+e.length);
    }
}
