package org.hxj.spark.jatrix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MatrixTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatrixTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MatrixTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        int[][] data = {
                {1,3,5},
                {2,4,6}
        };
        Matrix m = new Matrix(data);
        assertEquals(m.getColCount(), 3);
        assertEquals(m.getRowCount(), 2);
    }

    public void testPlus()
    {
        int[][] data = {
                {1,3,5},
                {2,4,6}
        };
        int[][] addend = {
                {1,1,1},
                {1,1,1}
        };

        Matrix m1 = new Matrix(data);
        Matrix m2 = new Matrix(addend);
        Matrix rst = m1.plus(m2);
        assertEquals(rst.getValueByCoor(0,0), 2);
        assertEquals(rst.getValueByCoor(0,1), 4);
        assertEquals(rst.getValueByCoor(0,2), 6);
        assertEquals(rst.getValueByCoor(1,0), 3);
        assertEquals(rst.getValueByCoor(1,1), 5);
        assertEquals(rst.getValueByCoor(1,2), 7);
    }
}
