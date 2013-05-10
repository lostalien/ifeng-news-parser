package org.hxj.dsa_java.collection;

/**
 * Created by IntelliJ IDEA.
 * User: huang_xj
 * Date: 13-5-10
 * Time: 下午12:11
 * To change this template use File | Settings | File Templates.
 */
public class MyLinkedList<E> implements MyList<E> {
    /**
     * 链头
     */
    private Node<E> head;
    /**
     * 链尾
     */
    private Node<E> tail;
    /**
     * 队列大小
     */
    private int size = 0;

    @Override
    public void add(E e) {

        Node<E> node = new Node<E>(e);

        if (size == 0) {

            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 在某个位置上添加元素
     *
     * @param index
     * @param e
     */
    @Override
    public void add(int index, E e) {

        Node<E> newNode = new Node<E>(e);
        if( index == 0 ){
            newNode.setNext( head );
            head = newNode;
        }/*else if( index + 1 == size ){
            tail.setNext( newNode);
            tail = newNode;
        }*/else{
            Node<E> pre = getNode(index - 1);
            Node<E> old = getNode(index);
            pre.setNext( newNode );
            newNode.setNext( old );
        }
        size++;
    }

    /**
     * 删除某个位置上的元素
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        if( index == 0 ){
            head = getNode( index + 1 );
        }else if( index + 1 == size ){
            tail = getNode( index - 1);
        }else{
            Node<E> p = getNode(index - 1);
            Node<E> n = getNode(index).getNext();
            p.setNext( n );
        }
        size--;
    }

    private Node<E> getNode(int index) {
        if (index >= size) {
            throw new RuntimeException("索引超出范围！");
        }

        Node<E> curr_node = null;
        for (int k = 0; k <= index; k++) {
            if (k == 0) {
                curr_node = head;
                continue;
            }
            curr_node = curr_node.getNext();
        }

        return curr_node;
    }

    @Override
    public E get(int index) {
        Node<E> target = getNode( index );
        return target.getData();
    }

    /**
     * 将线性表紧凑下，只对数组型线性表有意义
     */
    @Override
    public void compact() {
        throw new RuntimeException("不支持此操作！");
    }
}

class Node<E> {
    private E data;

    private Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    Node<E> getNext() {
        return next;
    }

    void setNext(Node<E> next) {
        this.next = next;
    }

    E getData() {
        return data;
    }

    void setData(E data) {
        this.data = data;
    }
}
