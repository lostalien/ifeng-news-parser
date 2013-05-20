package org.hxj.dsa_java.algorithm.sort;

/**
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-19
 * Time: 上午11:54
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {

    public static void sort(int[] arr) {

        if (arr.length == 1) {
            return;
        }

        sort(arr, 0, arr.length - 1);


    }

    private static void sort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int pivotIndex = partition(arr, low, high);
        sort(arr, low, pivotIndex - 1);
        sort(arr, pivotIndex + 1, high);
    }

    public static int partition(int[] arr, int first, int last) {
        //取数组的第一个元素为 中枢值
        int pivotIndex = first;
        int low = pivotIndex + 1;
        int high = last;

        while (low <= high) {
            //System.out.println("low的值为：" + arr[low] + "high的值为：" + arr[high]);
            if (arr[low] > arr[pivotIndex] && arr[high] < arr[pivotIndex]) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;

                low++;
                high--;
            } else if (arr[low] > arr[pivotIndex]) {
                high--;
            } else if (arr[high] < arr[pivotIndex]) {
                low++;
            } else {
                low++;
                high--;
            }
        }
        if (high > pivotIndex) {
            //交换 high 和 pivotIndex位置上的两个元素，并返回high位置，既当前中枢值所在的索引值。
            int tmp = arr[pivotIndex];
            arr[pivotIndex] = arr[high];
            arr[high] = tmp;
            //System.out.println( "pivot的位置：" + high);
            return high;
        }else{
            return pivotIndex;
        }


    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 3, 8, 4, 0, 1, 6, 7};
        sort(arr);
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }

        //System.out.println(partition());
    }
}
