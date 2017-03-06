package algorithms.sort;

import java.util.Arrays;

/**
 * Created by tiptop on 17-3-1.
 */
public class Selection {
    /**
     * 选择排序法。首先找到数组中最小的那个元素，然后与第一个元素交换.
     * (N-1)+(N-2)+....+1 = N(N-1)/2~N平方/2
     * 对于长度为N的数组，选择排序大约需要（N平方）/2次比较和N次交换。
     * @param a 输入数组
     */
    public static void sort1(int[] a) {
        int len = a.length;
        //第一层从0位置开始交换
        for (int i = 0; i < len; i++) {
            int b = i + 1;
            //寻找剩下的元素，如果有比a[i]小的就交换。
            for (int j = b; j < len; j++) {
                //可用exch()代替
                if (a[j] < a[i]) {
                   int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.println(a[i]);
        }

    }

    /**
     * 插入排序
     * @param a 参数。注意是包装类型
     */
    public static void sort2(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
        show(a);
    }

    public static void main(String[] args) {
        Integer[] i2 = {1,3,4,8,5,10,544,23,63};
        String[] chars = {"ab","a d","ac","ab"};
        sort2(chars);
    }

    /**
     * 对元素进行比较
     * @param v 传入参数
     * @param w 传入参数
     * @return 返回boolen
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换位置
     * @param a 传入参数
     * @param i 位置
     * @param j 位置
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 打印数组
     * @param a 传入数组元素
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * 测试数据是否有序
     * @param a 传入数组元素
     * @return boolean
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }
}
