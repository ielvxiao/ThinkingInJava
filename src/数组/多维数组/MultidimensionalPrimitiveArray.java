package 数组.多维数组;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/2.
 */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[][] a={
                {1,2,3},
                {4,5,6}
        };
        System.out.println(Arrays.deepToString(a));

        //p438
        int[][][] b=new int[2][2][4];
        System.out.println(Arrays.deepToString(b));
        //P438 粗糙数组
        Random rand = new Random(47);
        int[][][] c=new int[rand.nextInt(7)][][];
        for (int i = 0; i <c.length ; i++) {
            c[i] =new int[rand.nextInt(5)][];
            for (int j = 0; j <c[i].length ; j++) {
                c[i][j]=new int[rand.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(c));
    }
}
