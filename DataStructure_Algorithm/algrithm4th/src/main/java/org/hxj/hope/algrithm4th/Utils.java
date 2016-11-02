package org.hxj.hope.algrithm4th;

/**
 * Created by redemption on 2016/1/18.
 */
public class Utils {

    public static String integerToBinary(Integer i) {

        StringBuilder sb = new StringBuilder();

        for (int n = 31; n >= 0; n--) {
            if ((i & (1 << n)) != 0) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if ((32 - n) % 8 == 0) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }

    public static String integerToBinary2(Integer i) {

        String s = "";
        for(int n = i; n > 0; n /= 2){
            s = ( n % 2 ) + s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(integerToBinary2(1));
    }
}
