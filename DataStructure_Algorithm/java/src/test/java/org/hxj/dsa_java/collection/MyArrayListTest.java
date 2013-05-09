package org.hxj.dsa_java.collection;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MyArrayListTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MyArrayListTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MyArrayListTest.class);
    }

    /**
     * 测试添加元素
     */
    public void testAdd() {
        MyList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 23; i++) {
            list.add(((Double) (Math.random() * 100)).intValue());
        }
        Assert.assertEquals(23, list.size());
    }

    /**
     * 测试在某个位置上插入新元素
     */
    public void testAddAtIndex() {
        MyList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(1, 2);
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k));
        }
    }

    public void testRemove() {
        MyList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.print("移除前: ");
        for (int k = 0; k < list.size(); k++) {

            System.out.print(list.get(k));
            System.out.println("");
        }

        list.remove(0);
        System.out.print("移除后: ");
        for (int k = 0; k < list.size(); k++) {

            System.out.print(list.get(k));
            System.out.println("");
        }
    }

    /**
     * 测试取得元素
     */
    public void testGet() {
        MyList<Integer> list = new MyArrayList<Integer>();
        list.add(111);
        list.add(222);
        list.add(333);
        Assert.assertEquals(111, list.get(0).intValue());
        Assert.assertEquals(222, list.get(1).intValue());
        Assert.assertEquals(333, list.get(2).intValue());
    }
}
