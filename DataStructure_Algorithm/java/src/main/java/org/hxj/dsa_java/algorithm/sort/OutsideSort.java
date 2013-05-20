package org.hxj.dsa_java.algorithm.sort;

import java.io.*;
import java.util.Arrays;

/**
 * 外部排序
 * Created by IntelliJ IDEA.
 * User: redemption
 * Date: 13-5-19
 * Time: 下午7:23
 * To change this template use File | Settings | File Templates.
 */
public class OutsideSort {

    public static void createLargeFile() throws IOException {
        DataOutputStream out = new DataOutputStream( new BufferedOutputStream( new FileOutputStream("resources/large.dat")));
        for( int i = 0; i < 10000; i++ ){
            out.writeInt( (int)(Math.random() * 10000));
        }
        out.close();
    }

    public static void printFileContent() throws IOException {
        DataInputStream in = new DataInputStream( new BufferedInputStream( new FileInputStream("resources/large.dat")));
        while( in.available() > 0 ){
            System.out.print(in.readInt() + " ");
        }
    }

    public static int splitOriginalFileToSegments( int segmentSize, File originalFile, File destFile ) throws IOException {
        int[] segmentArr = new int[ segmentSize];
        DataInputStream reader = new DataInputStream( new BufferedInputStream( new FileInputStream( originalFile)));
        DataOutputStream writer = new DataOutputStream( new BufferedOutputStream( new FileOutputStream( destFile)));

        int segmentCount = 0;
        while( reader.available() > 0 ){
            segmentCount++;
            int i = 0;
            for(; reader.available() > 0 && i < segmentSize; i++ ){

                segmentArr[i] = reader.readInt();

            }
            Arrays.sort( segmentArr,0,i);
            for( int j = 0; j < i; j++){
                writer.writeInt(segmentArr[j]);
            }

        }
        writer.close();
        reader.close();
        return segmentCount;
    }

        public static void copyHalfOfSegmentsToFile( int segmentSize,int segmentCount, File segmentedFile, File destFile ) throws IOException {

            int halfCount = segmentCount / 2;
            DataInputStream reader = new DataInputStream( new BufferedInputStream( new FileInputStream( segmentedFile )));
            DataOutputStream writer = new DataOutputStream( new BufferedOutputStream( new FileOutputStream( destFile )));
            for( int i = 0; i < segmentSize * halfCount; i++ ){
                writer.writeInt( reader.readInt());
            }
        }

    public static void main(String[] args) throws IOException {
        //createLargeFile();
        //printFileContent();
        //int count = splitOriginalFileToSegments( 888, new File("resources/large.dat"), new File("resources/segmentedLarge.dat"));
        copyHalfOfSegmentsToFile( 888, 12, new File("resources/segmentedLarge.dat"), new File("resources/tmp2.dat"));
        //System.out.println(count);
    }
}
