package org.hxj.dsa_java.algorithm.sort;

import java.util.ArrayList;

/**
 * 用 ArrayList 来实现的堆
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-19
 * Time: 下午6:20
 * To change this template use File | Settings | File Templates.
 */
public class ArrayHeap<E extends Comparable> {
    //内部维护的一个数组线性表
    public ArrayList<E> innerList = new ArrayList<E>();

    public void add(E newData ){

        innerList.add( newData );
        //如果放进来的是第一个元素，那就是根节点，无需其它才做
        if( innerList.size() == 1 ){
            
        }else{
            int currentIndex = innerList.size() - 1;
            int parentIndex =  ( currentIndex - 1) / 2;
            E parent = innerList.get(parentIndex);
            while( currentIndex != 0 && parent.compareTo( newData ) < 0 ){
                E tmp = parent;
                innerList.set(parentIndex, innerList.get( currentIndex));
                innerList.set( currentIndex, tmp);

                currentIndex = parentIndex;
                parentIndex = ( currentIndex - 1 ) / 2;
                parent = innerList.get(parentIndex);
            }
        }
        System.out.println("add执行完毕，当前的数组：");
        for( E e : innerList ){
            System.out.print( e + " ");
        }
        System.out.println("");
    }
}
