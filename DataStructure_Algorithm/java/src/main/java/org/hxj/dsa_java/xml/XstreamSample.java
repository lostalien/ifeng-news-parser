package org.hxj.dsa_java.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hxj on 2017/2/5.
 */
public class XstreamSample {

    private static XStream xstream;
    static{
        xstream = new XStream(new DomDriver());
        //设置类别名
        xstream.alias("User",User.class);
        xstream.alias("Site",SourceSite.class);
        //设置类成员别名
        xstream.aliasField("domain",SourceSite.class,"domainName");
        //把SourceSite的name属性设置为xml属性，默认本来是作为xml标签的
        xstream.useAttributeFor(SourceSite.class,"name");
        //去掉集合类型生成xml的父节点，即忽略xml中的<sites></sites>标签
        xstream.addImplicitCollection(User.class,"sites");

        xstream.registerConverter( new DateConverter( Locale.CHINA ));
    }
    public static void main(String[] args) throws Exception {
        SourceSite ss1 = new SourceSite("baidu", "www.baidu.com");
        SourceSite ss2 = new SourceSite("sina", "www.sina.com");
        User user = new User();
        user.setName("黄晓静");
        user.addSite(ss1);
        user.addSite(ss2);
        user.setCreateTime( new Date());
        XstreamSample.objToXml( user );
    }

    public static void objToXml(Object obj ) throws Exception {
        FileOutputStream fos = new FileOutputStream("SourceSite2.xml");
        OutputStreamWriter osw = new OutputStreamWriter( fos, "utf8");
        xstream.toXML(obj,osw);
        fos.close();
    }
}
