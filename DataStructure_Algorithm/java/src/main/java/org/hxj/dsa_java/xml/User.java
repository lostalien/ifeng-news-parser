package org.hxj.dsa_java.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hxj on 2017/2/5.
 */
public class User {
    public String name;
    public SourceSite ss;
    public List<SourceSite> sites = new ArrayList<SourceSite>();
    public Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void addSite(SourceSite site ){
        sites.add( site );
    }

    public List<SourceSite> getSites() {
        return sites;
    }

    public void setSites(List<SourceSite> sites) {
        this.sites = sites;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceSite getSs() {
        return ss;
    }

    public void setSs(SourceSite ss) {
        this.ss = ss;
    }
}
