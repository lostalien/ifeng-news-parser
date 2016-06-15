package org.hxj.spark.jatrix;

/**矩阵
 * Created by redemption on 2016/6/15.
 */
public class Matrix {

    private int[][] arr;

    private int rowCount = -1;
    private int colCount = -1;

    public Matrix() {
    }

    public Matrix( int[][] data ){
        //检查传入的二维数组是否满足矩阵的特性
        if( !isMatrix( data ) ){
            throw new IllegalArgumentException("传入的二维数组不满足矩阵要求。");
        }
        this.arr = data;
    }

    /**
     * 加法
     * @param addend
     * @return
     */
    public Matrix plus( Matrix addend ){
        if( this.rowCount != addend.getRowCount()
                && this.colCount != addend.getColCount() ){
            throw new IllegalArgumentException("传入的矩阵不满足与本矩阵相加的条件。");
        }
        //对应位置相加
        int[][] result = new int[this.rowCount][this.colCount];
        for(int r = 0; r < this.rowCount; r++ ){
            for( int c = 0; c < this.colCount; c++ ){
                result[r][c] = this.arr[r][c] + addend.getValueByCoor(r,c);
            }
        }

        Matrix resultMatrix = new Matrix( result );
        return resultMatrix;
    }

    /**
     * 加法
     * @param addend
     * @return
     */
    public Matrix minus( Matrix addend ){
        if( this.rowCount != addend.getRowCount()
                && this.colCount != addend.getColCount() ){
            throw new IllegalArgumentException("传入的矩阵不满足与本矩阵相加的条件。");
        }
        //对应位置相加
        int[][] result = new int[this.rowCount][this.colCount];
        for(int r = 0; r < this.rowCount; r++ ){
            for( int c = 0; c < this.colCount; c++ ){
                result[r][c] = this.arr[r][c] - addend.getValueByCoor(r,c);
            }
        }

        Matrix resultMatrix = new Matrix( result );
        return resultMatrix;
    }

    /**
     * 乘法
     * @param m2
     * @return
     */
    public Matrix multi( Matrix m2 ){
        return null;
    }

    public int getValueByCoor( int r, int c ){
        return this.arr[r][c];
    }

    public int getRowCount(){
        return this.rowCount;
    }

    public int getColCount(){
        return this.colCount;
    }

    /**
     * 判断是否是矩阵
     * @param data
     * @return
     */
    private boolean isMatrix( int[][] data ){
        //是否每个每行每列都有数据
        int row1ColCount = data[0].length;
        for( int i = 1; i < data.length; i++ ){
            int[] row = data[i];
            int len = row.length;
            if( len == row1ColCount ){
                continue;
            }else{
                return false;
            }
        }

        this.rowCount = data.length;
        this.colCount = row1ColCount;
        return true;
    }
}
