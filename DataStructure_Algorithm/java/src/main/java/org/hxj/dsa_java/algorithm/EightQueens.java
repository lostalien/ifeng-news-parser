package org.hxj.dsa_java.algorithm;

/**
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-12
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public class EightQueens {

    int[] board = new int[8];

    private boolean searchRow( int row ){
        if( row == 8){
            return true;
        }

        for( int col = 0; col < 8; col++ ){
            board[row] = col;
            if( isValid( row,col ) && searchRow( row + 1)){
                return true;
            }
        }
        return false;
    }

    private boolean isValid( int row, int column ){
        /*for( int r = )
        if( board[ row] )*/
        return true;
    }
}
