package algorithms;

import java.util.Random;

public class QuickSortExperiment {

    // 以下变量的值可以根据实验情况酌情修改
    public static int ELEMENTS_NUM[] = {100000,500000,1000000};//每次进行快速排序的数组所含元素的个数
    public static int K=15;//改进算法中k的取值
    public static int COUNT=5; //每次测试采样的次数。各次采样结果求和取平均得到本次的实验结果
    public static long time_record[][]=new long[ELEMENTS_NUM.length][4];//保存对本次实验的四个算法进行elumNum中各测试次数所得到的结果时间

    /* 生成长度为num的随机数组*/
    public static int[] getRandIntArray(int num){
        int[] data = new int[num];
        Random rd = new Random();
        for(int i=0;i<num;i++){
            data[i]=rd.nextInt(1000);
        }
        return data;
    }
    /* 判断整形数组是否递增有序 */
    public static boolean isAscSorted(int a[]){
        int length = a.length;
        for(int i=1;i<length;i++){
            if(a[i]<a[i-1]){
                return false;
            }
        }
        return true;
    }
    /* 获取划分元的位置
     * 下面的方法采用的是算法导论书本上采用的方法
     * 单向遍历数组确定划分元的位置
     */
    public static int partition1(int a[],int low, int high){
        int pivotValue=a[high]; //划分元位置
        int i=low-1;
        int tmp;
        for(int j=low;j<high;j++){
            if(a[j]<=pivotValue){
                i++;
                tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }
        tmp=a[i+1];
        a[i+1]=a[high];
        a[high]=tmp;
        return i+1;
    }
    /* 获取划分元的位置
     * 下面的方法采用的是双向遍历数组确定划分元的位置
     */
    public static int partition2(int a[],int low, int high){
        int pivotValue = a[low];

        while(low < high){
            //从右边找比枢纽元素小的的元素
            while((low < high) && (a[high] >= pivotValue)){
                high--;
            }
            //交换两个元素
            a[low] = a[high];
            //从左边找比枢纽元素大的的元素
            while((low < high) && (a[low] <= pivotValue)){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivotValue;
        return low;
    }
    /* 插入排序 */
    public static void insertSort(int a[], int p, int r){
        for (int i = p+1; i <= r; i++) {
            int key = a[i];
            int j = i - 1;
            while(j >= p && a[j] > key){
                a[j + 1] = a[j];
                j --;
            }
            a[j + 1] = key;
        }
    }
    /* 使用partition1划分的方式对数组进行快速排序 */
    public static void quickSortUsingPartition1(int a[],int low,int high){
        if(low < high){
            int mid =partition1(a,low,high);
            quickSortUsingPartition1(a,low,mid-1);
            quickSortUsingPartition1(a,mid+1,high);
        }
    }
    /* 使用partition2划分的方式对数组进行快速排序 */
    public static void quickSortUsingPartition2(int a[],int low,int high){
        if(low < high){
            int mid =partition2(a,low,high);
            quickSortUsingPartition2(a,low,mid-1);
            quickSortUsingPartition2(a,mid+1,high);
        }
    }
    /* 结合insertSort对partition1划分的方式对数组进行快速排序 */
    public static void insertQuickSortUsingPartition1(int a[],int low,int high){
        if(low>=high)return;
        else if(high-low >= K){
            int mid =partition1(a,low,high);
            quickSortUsingPartition1(a,low,mid-1);
            quickSortUsingPartition1(a,mid+1,high);
        }
        else{
            insertSort(a, low, high);
        }

    }
    /* 结合insertSort对partition2划分的方式对数组进行快速排序 */
    public static void insertQuickSortUsingPartition2(int a[],int low,int high){
        if(low>=high)return;
        else if(high-low >= K){
            int mid =partition2(a,low,high);
            quickSortUsingPartition2(a,low,mid-1);
            quickSortUsingPartition2(a,mid+1,high);
        }
        else{
            insertSort(a, low, high);
        }

    }
    /* 对两种快速排序算法进行测试并比较 */
    public static void recordQS_P1(){
        int testAry[];//每次进行快速排序的数组
        long totalTime,start,end;
        for(int i=0;i<ELEMENTS_NUM.length;i++){
            int j=1;
            totalTime = 0;
            while(j<=COUNT){
                testAry = getRandIntArray(ELEMENTS_NUM[i]);
                start = System.currentTimeMillis();
                quickSortUsingPartition1(testAry, 0, ELEMENTS_NUM[i]-1);
                end = System.currentTimeMillis();
                totalTime = totalTime + (end -start);
                j++;
//              System.out.println(isAscSorted(testAry));
            }
            time_record[i][0] = totalTime/COUNT;//取平均
        }
    }
    public static void recordQS_P2(){
        int testAry[];//每次进行快速排序的数组
        long totalTime,start,end;
        for(int i=0;i<ELEMENTS_NUM.length;i++){
            int j=1;
            totalTime = 0;
            while(j<=COUNT){
                testAry = getRandIntArray(ELEMENTS_NUM[i]);
                start = System.currentTimeMillis();
                quickSortUsingPartition2(testAry, 0, ELEMENTS_NUM[i]-1);
                end = System.currentTimeMillis();
                totalTime = totalTime + (end -start);
                j++;
//              System.out.println(isAscSorted(testAry));
            }
            time_record[i][1] = totalTime/COUNT;//取平均
        }
    }

    public static void recordIQS_P1(){
        int testAry[];//每次进行快速排序的数组
        long totalTime,start,end;
        for(int i=0;i<ELEMENTS_NUM.length;i++){
            int j=1;
            totalTime = 0;
            while(j<=COUNT){
                testAry = getRandIntArray(ELEMENTS_NUM[i]);
                start = System.currentTimeMillis();
                insertQuickSortUsingPartition1(testAry, 0, ELEMENTS_NUM[i]-1);
                end = System.currentTimeMillis();
                totalTime = totalTime + (end -start);
                j++;
//              System.out.println(isAscSorted(testAry));
            }
            time_record[i][2] = totalTime/COUNT;//取平均
        }
    }
    public static void recordIQS_P2(){
        int testAry[];//每次进行快速排序的数组
        long totalTime,start,end;
        for(int i=0;i<ELEMENTS_NUM.length;i++){
            int j=1;
            totalTime = 0;
            while(j<=COUNT){
                testAry = getRandIntArray(ELEMENTS_NUM[i]);
                start = System.currentTimeMillis();
                insertQuickSortUsingPartition2(testAry, 0, ELEMENTS_NUM[i]-1);
                end = System.currentTimeMillis();
                totalTime = totalTime + (end -start);
                j++;
//              System.out.println(isAscSorted(testAry));
            }
            time_record[i][3] = totalTime/COUNT;//取平均
        }
    }

    public static void printTime() {
        System.out.println("\t\t[快排_单向]\t[快排_双向]\t[插入快排_单向K="+K+"]\t[插入快排_双向K="+K+"]");
        for(int i=0;i<ELEMENTS_NUM.length;i++){
            System.out.print(ELEMENTS_NUM[i]+"个元素\t");
            for(int j=0;j<4;j++){
                System.out.print(time_record[i][j]+"\t\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /*
         * 实验目的一
         */
        System.out.println("实验测试1：采用不同的划分元位置确定方法的快排序和插入快排序对不同元素总数的执行结果。单位:ms");
        recordQS_P1();
        recordQS_P2();
        recordIQS_P1();
        recordIQS_P2();
        printTime();

        /*
         * 实验目的二
         */
        QuickSortExperiment.ELEMENTS_NUM=new int[]{100000};
        QuickSortExperiment.COUNT=20;//提高精度
        int somek[]={2,5,7,8,9,10,11,12,13,14,15,
                16,17,18,19,20,21,22,24,25,28,30,
                35,80,100,500};
        time_record=new long[ELEMENTS_NUM.length][4];//清空变量的值

        System.out.println("\n实验测试2：K值大小对优化算法结果的影响(以下数据取自100000个数据的插入快排_双向算法执行结果)");
        System.out.println("注：log(100000)="+Math.log(100000)/Math.log(2));
        System.out.println("K值\t\t时间（ms）");
        for(int value:somek){
            QuickSortExperiment.K=value;
            recordIQS_P2();//调用插入算法改进后的快排序，运行时间保存在 time_record[0][3]
            System.out.println(value+"\t\t"+time_record[0][3]);
        }


    }

}
