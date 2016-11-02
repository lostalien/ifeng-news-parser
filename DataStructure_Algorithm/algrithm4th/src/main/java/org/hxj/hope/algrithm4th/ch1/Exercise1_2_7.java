package org.hxj.hope.algrithm4th.ch1;

/**
 * Created by redemption on 2016/1/21.
 */
public class Exercise1_2_7 {

    public static void main(String[] args) {
        System.out.println(mystery("abcde"));
    }

    public static String mystery(String s){
        int N = s.length();
        if( N <= 1 ) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
}
