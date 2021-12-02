/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solent_campers;

import java.util.ArrayList;
import solent_campers.Modal.camping_sites;

/**
 *
 * @author kaur
 */
public class CampingSiteHelper {

    public static ArrayList<camping_sites> siteList;
    public CampingSiteHelper() {
        siteList=new ArrayList<camping_sites>();
        siteList.add(new camping_sites(1,"X Forest","CAmp 1"));
         siteList.add(new camping_sites(2,"Y River","CAmp 2"));
          siteList.add(new camping_sites(3,"Z Hills","CAmp 3"));
           siteList.add(new camping_sites(4,"X Forest","CAmp 4"));
    }
    
    
    public void AddSite(camping_sites cv)
{
    siteList.add(cv);
}

public void updateSite(int id,camping_sites cv)
{
    siteList.set(id,cv);
}
public void deleteSite(int id)
{
   for(int i=0;i<siteList.size();i++)
   {
       if(siteList.get(i).getCs_id()==id)
       {
         siteList.remove(i);
         break;
       }
   }
}
public camping_sites getSite(int id)
{
    for(int i=0;i<siteList.size();i++)
   {if(siteList.get(i).getCs_id()==id)
   {
        return siteList.get(i);
        
   }  
   }
   return null;
}

public ArrayList<camping_sites> getSiteBasedonRegion(String region)
{
    ArrayList<camping_sites> cs=new ArrayList<camping_sites>();
    for(int i=0;i<siteList.size();i++)
   {if(siteList.get(i).getRegion().equalsIgnoreCase(region))
   {
      cs.add(siteList.get(i));
        
   }  
   }
   return cs;
}

public ArrayList<String> getAllRegion()
{
     ArrayList<String> regions=new ArrayList<String>();
    for(int i=0;i<siteList.size();i++)
   {
       if(!regions.contains(siteList.get(i).getRegion())){
       regions.add(siteList.get(i).getRegion());}
   }
   return regions;
}
public ArrayList<camping_sites> getAll()
{
    return siteList;
}
}
