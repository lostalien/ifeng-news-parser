package org.hxj.hope.algrithm4th.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by redemption on 2016/1/18.
 */
public class Exercise1_1_7 {

    public static void main(String[] args) {
        double t = 9.0;
        System.out.println( ( 9.0/t + t) / 2.0 );
        while(Math.abs( t - 9.0/t ) > .001)
            t = ( 9.0/t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

    }
}
