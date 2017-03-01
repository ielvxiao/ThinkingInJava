package algorithms.sort;

import java.util.Arrays;

/**
 * Created by tiptop on 17-3-1.
 */
public class Selection {
    /**
     * 选择排序法。首先找到数组中最小的那个元素，然后与第一个元素交换
     * @param a 输入数组
     */
    public static void sort(int[] a) {
        int len = a.length;
        //第一层从0位置开始交换
        for (int i = 0; i < len; i++) {
            int b = i + 1;
            //寻找剩下的元素，如果有比a[i]小的就交换。
            for (int j = b; j < len; j++) {
                if (a[j] < a[i]) {
                   int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            System.out.println(a[i]);
        }

    }

    public static void main(String[] args) {
        sort(new int[]{1,3,4,2,34,523});
    }
}
