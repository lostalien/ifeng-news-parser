package org.hxj.dsa_java.algorithm.sort;

/**
 * 整数的归并排序
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-18
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {

    public static void sort(int[] arr) {
        split( arr );
    }

    private static void split(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int[] firstHalf = new int[arr.length / 2];
        System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
        split(firstHalf);

        int[] secondHalf = new int[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length/2, secondHalf, 0, arr.length - arr.length / 2);
        split(secondHalf);

        int[] rst = merge(firstHalf, secondHalf);
        System.arraycopy(rst,0,arr,0,rst.length);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] rst = new int[first.length + second.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int rstPointer = 0;

        for (int i = 0; i < rst.length; i++) {
            if (firstPointer < first.length && secondPointer < second.length) {
                if (first[firstPointer] < second[secondPointer]) {
                    rst[i] = first[firstPointer];
                    firstPointer++;
                } else {
                    rst[i] = second[secondPointer];
                    secondPointer++;
                }
            }else if( firstPointer < first.length ){
                rst[i] = first[firstPointer];
                firstPointer++;
            }else if( secondPointer < second.length ){
                rst[i] = second[secondPointer];
                secondPointer++;
            }

        }
        return rst;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7};
        sort(arr);
        for( int i = 0;i < arr.length; i++ ){
            System.out.println(arr[i]);
        }
    }
}
