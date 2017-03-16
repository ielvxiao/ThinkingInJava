import java.util.Random;

/**
 * @author Administrator
 * @date 2017/3/15
 */
public class QuickSortTest {
    Random rand = new Random();
    int[] arr;
    /**
     * 交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sort1(int[] a, int p, int r) {
        arr = a;
        //0或者1个元素直接返回
        if (p >=r)
            return;
        //选择左断电作为pivot
        int x = a[p];
        int j = p;
        for (int i = p + 1; i <= r; i++) {
            //小于pivot的放在左边
            if (a[i] < x)
                swap(a, ++j, i);
        }
        //交换左端点和pivot的位置
        swap(a, p, j);
        //递归子序列
        sort1(a, p, j-1);
        sort1(a, j + 1, r);
    }

    public void qsort2(int[] a, int p, int r) {
        // 0个或1个元素，返回
        if (p >= r)
            return;
        // 随机选择pivot
        int i = p + rand.nextInt(r - p + 1);
        // 交换pivot和左端点
        swap(a, p, i);
        // 划分算法不变
        int x = a[p];
        int j = p;
        for (i = p + 1; i <= r; i++) {
            // 小于pivot的放到左边
            if (a[i] < x) {
                swap(a, ++j, i);
            }
        }
        // 交换左端点和pivot位置
        swap(a, p, j);
        // 递归子序列
        qsort2(a, p, j - 1);
        qsort2(a, j + 1, r);
    }

    public void qsort7(int[] x, int p, int r) {
        if (p >= r)
            return;

        // 在数组大小小于7的情况下使用快速排序
        if (r - p + 1 < 7) {
            for (int i = p; i <= r; i++) {
                for (int j = i; j > p && x[j - 1] > x[j]; j--) {
                    swap(x, j, j - 1);
                }
            }
            return;
        }

        // 选择中数，与qsort6相同。
        int len = r - p + 1;
        int m = p + (len >> 1);
        if (len > 7) {
            int l = p;
            int n = p + len - 1;
            if (len > 40) {
                int s = len / 8;
                l = med3(x, l, l + s, l + 2 * s);
                m = med3(x, m - s, m, m + s);
                n = med3(x, n - 2 * s, n - s, n);
            }
            m = med3(x, l, m, n);
        }

        int v = x[m];

        // a,b进行左端扫描，c,d进行右端扫描
        int a = p, b = a, c = p + len - 1, d = c;
        while (true) {
            // 尝试找到大于pivot的元素
            while (b <= c && x[b] <= v) {
                // 与pivot相同的交换到左端
                if (x[b] == v)
                    swap(x, a++, b);
                b++;
            }
            // 尝试找到小于pivot的元素
            while (c >= b && x[c] >= v) {
                // 与pivot相同的交换到右端
                if (x[c] == v)
                    swap(x, c, d--);
                c--;
            }
            if (b > c)
                break;
            // 交换找到的元素
            swap(x, b++, c--);
        }

        // 将相同的元素交换到中间
        int s, n = p + len;
        s = Math.min(a - p, b - a);
        vecswap(x, p, b - s, s);
        s = Math.min(d - c, n - d - 1);
        vecswap(x, b, n - s, s);

        // 递归调用子序列
        if ((s = b - a) > 1)
            qsort7(x, p, s + p - 1);
        if ((s = d - c) > 1)
            qsort7(x, n - s, n - 1);

    }

    private static int med3(int x[], int a, int b, int c) {
        return x[a] < x[b] ? (x[b] < x[c] ? b : x[a] < x[c] ? c : a)
                : x[b] > x[c] ? b : x[a] > x[c] ? c : a;
    }

    private static void vecswap(int x[], int a, int b, int n) {
        for (int i = 0; i < n; i++, a++, b++)
            swap(x, a, b);
    }

    public static void main(String[] args) {
        QuickSortTest test = new QuickSortTest();
        test.qsort7(new int[]{1,3,4,13,12,5,1}, 0, 6);
        for (int i: test.arr
             ) {
            System.out.println(i);
        }
    }
}
