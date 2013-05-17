package org.hxj.dsa_java.algorithm;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-11
 * Time: 上午9:29
 * To change this template use File | Settings | File Templates.
 */
public class ComputeFactorial {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("请输入一个整数： ");
        int i = userInput.nextInt();

        System.out.print( i + "的阶乘为：" + compute( i ));
    }

    public static int compute( int n ){
        if( n == 0 ){
            return 1;
        }else {
            return n * compute( n - 1 );
        }
    }
}
