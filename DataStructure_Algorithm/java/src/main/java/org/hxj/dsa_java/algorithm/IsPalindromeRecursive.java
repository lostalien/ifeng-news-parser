package org.hxj.dsa_java.algorithm;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-12
 * Time: 上午8:48
 * To change this template use File | Settings | File Templates.
 */
public class IsPalindromeRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String input = scanner.next();
        System.out.println(input + "是回文字符串吗？ " + isPalindrome( input ));
    }

    public static boolean isPalindrome(String s ){
        if( s.length() == 1 ){
            return true;
        }else if( s.charAt(0) != s.charAt( s.length() - 1)){
            return false;
        }else{
            return isPalindrome( s.substring( 1, s.length() - 1));
        }
    }
}
