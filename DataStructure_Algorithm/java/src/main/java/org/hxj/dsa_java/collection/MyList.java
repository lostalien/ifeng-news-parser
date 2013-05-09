package org.hxj.dsa_java.collection;

/**
 * Created by IntelliJ IDEA.
 * User: huang_xj
 * Date: 13-5-9
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */

public interface MyList<E>{

    void add(E e);

    int size();

    /**
     * 在某个位置上添加元素
     * @param index
     * @param e
     */
    void add(int index, E e );

    /**
     * 删除某个位置上的元素
     * @param index
     */
    void remove( int index );

    E get(int index );
}
