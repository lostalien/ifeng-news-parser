package org.hxj.dsa_java.xml;

/**
 * Created by hxj on 2017/2/5.
 */
public class SourceSite {
    public String name;
    public String domainName;

    public SourceSite() {
    }

    public SourceSite(String name, String domainName) {
        this.name = name;
        this.domainName = domainName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
