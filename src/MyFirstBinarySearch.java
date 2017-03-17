/**
 * @author Administrator
 * @date 2017/3/16
 */
public class MyFirstBinarySearch {
    private static int sort(int[] a, int sear) {
        int len = a.length;
        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (sear < mid) hi = mid - 1;
            if (sear > mid) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1,2,3,4,5,6,7}, 5));
    }
}
