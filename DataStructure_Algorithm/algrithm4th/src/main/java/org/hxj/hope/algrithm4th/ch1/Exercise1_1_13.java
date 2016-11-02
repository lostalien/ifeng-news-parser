package org.hxj.hope.algrithm4th.ch1;

import java.util.Scanner;

/**
 * Created by redemption on 2016/1/18.
 */
public class Exercise1_1_13 {

    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        Scanner scn = new Scanner(System.in);
        System.out.print("矩阵有几行？：");
        row = scn.nextInt();
        System.out.print("矩阵有几列？：");
        col = scn.nextInt();
        //scn.close();
        int[][] matrix = new int[row][col];
        inputElement(matrix);
        printMatrix(matrix);
        printMatrix(reverseMatrix(matrix));

    }

    public static void printMatrix(int[][] matrix){
        for(int r = 0; r < matrix.length; r++ ){

            for( int c = 0; c < matrix[r].length; c++ ){
                System.out.print( matrix[r][c]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static int[][] reverseMatrix(int[][] matrix){
        if(matrix == null){
            throw new NullPointerException();
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] rm = new int[col][row];
        for( int c = 0; c < col; c++ ){

            for( int r = 0; r < row; r++ ){
                rm[c][r] = matrix[r][c];
            }
        }
        return rm;
    }

    public static void inputElement(int[][] matrix){
        int e = 0;
        Scanner scn = new Scanner(System.in);
        for(int r = 0; r < matrix.length; r++ ){

            for( int c = 0; c < matrix[r].length; c++ ){
                System.out.print("请输入第" + r + "行第" + c + "列的值：");
                e = scn.nextInt();
                matrix[r][c] = e;
            }

        }
        System.out.println("输入完毕");
    }
}
