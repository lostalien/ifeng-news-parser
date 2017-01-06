package org.hxj.hope;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeVisitor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        MyVisitor visitor = new MyVisitor();
        body.traverse(visitor);
        System.out.println(visitor.getNodeStick());
    }

    static class MyVisitor implements NodeVisitor{

        private String nodeStick = "";
        @Override
        public void head(Node node, int depth) {
            System.out.println(node.nodeName());
            nodeStick += node.nodeName();
        }

        @Override
        public void tail(Node node, int depth) {

        }

        public String getNodeStick(){
            return nodeStick;
        }
    }
}
