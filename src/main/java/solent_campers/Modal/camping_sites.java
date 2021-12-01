/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent_campers.Modal;

/**
 *
 * @author asus
 */
public class camping_sites {

    public String getCamping_sites() {
        return camping_sites;
    }

    public void setCamping_sites(String camping_sites) {
        this.camping_sites = camping_sites;
    }

    public int getCs_id() {
        return cs_id;
    }

    public void setCs_id(int cs_id) {
        this.cs_id = cs_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

int cs_id=0;
String region="";
String camping_sites="";

public camping_sites(int cs_id, String reg,String camp)
{
    this.cs_id=cs_id;
    region=reg;
    camping_sites=camp;
}
public camping_sites getData()
{
    return new camping_sites(this.cs_id, this.region,this.camping_sites);
}
}

