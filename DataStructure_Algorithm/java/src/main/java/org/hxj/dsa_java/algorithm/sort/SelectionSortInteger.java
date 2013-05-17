package org.hxj.dsa_java.algorithm.sort;

/**
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-12
 * Time: 上午10:07
 * To change this template use File | Settings | File Templates.
 */
public class SelectionSortInteger {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort( arr );
        for( int k = 0; k < arr.length; k++ ){
            System.out.println( arr[k]);
        }
    }

    public static void sort( int[] arr ){
        sort( arr, 0 );
    }
    private static void sort(int[] arr, int low ){
        //System.out.println(low);
        if( low == arr.length - 1){
            return;
        }
        int minIndex = low;
        for( int k = low + 1; k < arr.length; k++ ){
            if( arr[k] < arr[minIndex]){
                minIndex = arr[k];
            }
        }
        int tmp = arr[minIndex];
        arr[minIndex] = arr[low];
        arr[low] = tmp;
        low++;
        sort( arr, low);
    }
}
