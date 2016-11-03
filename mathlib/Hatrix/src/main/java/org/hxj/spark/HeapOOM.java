package org.hxj.spark;

import java.util.ArrayList;
import java.util.List;

/**测试堆OOM
 * Created by redemption on 2016/7/14.
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList();

        while(true){
            list.add( new OOMObject() );
        }
    }
}
