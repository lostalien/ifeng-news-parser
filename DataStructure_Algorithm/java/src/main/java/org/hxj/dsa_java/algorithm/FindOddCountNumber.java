package org.hxj.dsa_java.algorithm;

/**
 * 这个网上看到的面试题的算法实现 http://blog.jobbole.com/106521/    http://longcxm.iteye.com/blog/1461543
 * Created by redemption on 2016/11/2.
 */
public class FindOddCountNumber {
    public static void main(String[] args) {
        int[] nums = {8,8,5,5,2,2,2,2,8};
        int rst = 0;
        for( int i = 0; i < nums.length; i++ ){
            rst ^= nums[i];
        }
        System.out.println(rst);
        System.out.println( 8^8 ^  5 ^ 5 ^ 2 ^ 2 ^ 2 ^ 2 ^8 );
    }
}
