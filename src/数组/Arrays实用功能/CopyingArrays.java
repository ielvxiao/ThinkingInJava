package 数组.Arrays实用功能;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/9.
 * 不太明白。。。
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j =new int[10];
        Arrays.fill(i,47);
        Arrays.fill(j,99);
        System.out.println("i="+Arrays.toString(i));
        System.out.println("j="+Arrays.toString(j));
        System.arraycopy(i,0,j,0,i.length);
        System.out.println("j="+Arrays.toString(j));
        int[] k= new int[5];
        Arrays.fill(k,103);
        System.arraycopy(i,0,k,0,k.length);
        System.out.println("k="+Arrays.toString(k));
    }
}
