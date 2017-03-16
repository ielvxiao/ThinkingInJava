package algorithms.sort;

import java.io.*;
/**
 * @author Administrator
 * @date 2017/3/15
 */
public class SortTest2 {
    private int array[];
    private int length;
    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length -1);
    }

    public void quickSort(int lowerIndex, int higherIndex) {
        int i =lowerIndex;
        int j = higherIndex;
        int paviot = array[(lowerIndex + higherIndex) / 2];
        while (i <= j) {
            while (array[i] < paviot)
                i++;
            while (array[j] > paviot)
                j--;
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        SortTest2 test = new SortTest2();
        test.sort(new int[]{2,1,3,5,4});
        for (int a: test.array
             ) {
            System.out.println(a);
        }
    }
}
