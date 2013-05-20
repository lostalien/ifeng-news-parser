package org.hxj.dsa_java.algorithm.sort;

/**
 * 堆排序，就是用 堆 这个数据结构来排序，
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-19
 * Time: 下午6:19
 * To change this template use File | Settings | File Templates.
 */
public class HeapSort {

    public static void main(String[] args) {
        ArrayHeap<Integer> heap = new ArrayHeap<Integer>();
        heap.add( 1 );
        heap.add( 9 );
        heap.add( 8 );
        heap.add( 3 );

        for( Integer i : heap.innerList ){
            System.out.println( i );
        }
    }
}
