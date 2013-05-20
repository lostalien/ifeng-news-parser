package org.hxj.dsa_java.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序，只适合待排序的数字最大值比较小的时候
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-18
 * Time: 下午8:30
 * To change this template use File | Settings | File Templates.
 */
public class BucketSort {

    public static void sort( int[] arr ){
        int max = 1000;
        //假设arr中最大的数是1000
        List<List> buckets = new ArrayList<List>(max);
        //每个桶都是List型
        /*for( List b : buckets ){
            b =;
        }*/
        for( int i = 0; i < max; i++ ){
            buckets.add(  new ArrayList<Integer>() );
        }
        //将待排序的数组中的元素放入桶中
        for( int i = 0; i < arr.length; i++ ){
            buckets.get( arr[i] ).add( arr[i]) ;
        }
        //将桶中的数放回数组中
        int k = 0;
        for( List<Integer> b : buckets ){
            if( b.size() != 0 ){
                for( Integer data : b ){
                    arr[k] = data;
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7};
        //int[] arr2 = new int[]{9,5,2,7};
        sort(arr);
        for( int k = 0; k < arr.length; k++ ){
            System.out.println(arr[k]);
        }
    }
}
