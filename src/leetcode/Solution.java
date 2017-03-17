package leetcode;

/**
 * Created by Administrator on 2017/3/14.
 */
public class Solution {
    public static int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5,5,6,7,7,8,8,9,9,10,10}));
    }
}