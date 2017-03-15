package algorithms.sort;

/**
 * Created by Administrator on 2017/3/14.
 */
public class MyQuickSort {

    private int array[];
    private int length;
    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length-1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        //找到中间那个的位置
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        //分割成两个array
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        MyQuickSort sorter = new MyQuickSort();
        int[] intpu = {1,3,5,78,2,2,2,2,2,2,12,57,23,685,231,1,0};
        sorter.sort(intpu);
        for (int i: intpu
             ) {
            System.out.println(i);
        }
    }
}
