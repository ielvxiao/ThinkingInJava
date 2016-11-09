package 数组.Arrays实用功能;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1,90);
        Arrays.fill(a2,90);
        System.out.println(Arrays.equals(a1,a2)); //完全相同
        a2[3]=11;
        System.out.println(Arrays.equals(a1,a2));//s2改变
        String[] s1=new String[3];
        Arrays.fill(s1,"hi");
        String[] s2={new String("hi"),new String("hi"),new String("hi")};
        System.out.println(Arrays.equals(s1,s2)); //比较的是内容与Object.equals()相同
    }
}
