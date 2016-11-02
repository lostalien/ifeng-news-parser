package org.hxj.hope.algrithm4th.ch1;

import java.util.Scanner;

/**
 * Created by redemption on 2016/1/18.
 */
public class Exercise1_1_3 {
    public static void main(String[] args) {
        int n1 = 0;
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        int n2 = 0;
        n2 = scanner.nextInt();
        int n3 = 0;
        n3 = scanner.nextInt();

        if( (n1 == n2) && ( n1 == n3 )){
            System.out.println("想等");
        }else {
            System.out.println("不相等");
        }
    }
}
