package org.hxj.dsa_java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: huang_xj
 * Date: 13-5-9
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
public class MyArrayList<E> implements MyList<E> {

    private final int  INITIAL_CAPACITY = 5;

    private E[] array = (E[])new Object[INITIAL_CAPACITY];

    private int current_index = -1;

    @Override
    public void add(E e) {
        if( current_index + 1 == array.length ){
            amplify();
        }
        current_index++;
        array[current_index] = e;
    }

    /**
     * 在某个位置上添加元素
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {
        if( index > current_index || index < 0 ){
            throw new IndexOutOfBoundsException("您要添加的位置不存在！");
        }
        //如果数组满了，就扩容
        if( array.length == current_index + 1 ){
            amplify();
        }
        //将当前index处及其之后的值后移
        for( int k = current_index; k >= index; k--){
            array[k+1] = array[k];
        }
        array[index] = e;
        current_index++;
    }

    private void amplify(){
        E[] newArray = (E[])new Object[((Double)(array.length * 1.5)).intValue()];
        System.arraycopy(array, 0, newArray,0, size() );
        array = newArray;
    }

    /**
     * 删除某个位置上的元素
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        if( index > current_index || index < 0 ){
            throw new IndexOutOfBoundsException("您要添加的位置不存在！");
        }else if( index == current_index ){//如果要移除的是最后一个
            current_index--;
            return;
        }
        //将index之后的元素前移1位
        for( int k = index + 1; k <= current_index; k++){
            array[k-1] = array[k];
        }
        current_index--;
        compact();

    }

    /**
     * 将线性表紧凑下，只对数组型线性表有意义
     */
    @Override
    public void compact() {
        E[] newArray = (E[])new Object[current_index + 1];
        System.arraycopy( array, 0, newArray, 0, current_index + 1 );
        array = newArray;
    }

    @Override
    public int size() {
        return current_index + 1;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        test.add( 10, 13 );
        System.out.println( test.size() );
    }
}
