/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solent_campers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import solent_campers.Modal.camping_sites;

/**
 *
 * @author kaur
 */
public class CampingSiteHelper {

    public static ArrayList<camping_sites> siteList;
    String row="";
    public CampingSiteHelper() {
       readAll();
    }
    
    
    public void AddSite(camping_sites cv)
{
    siteList=readAll();
    siteList.add(cv);
    writeAll(siteList);
}

public void updateSite(int id,camping_sites cv)
{
    siteList.set(id,cv);
}
public void deleteSite(int id)
{
   siteList= readAll();
   for(int i=0;i<siteList.size();i++)
   {
       if(siteList.get(i).getCs_id()==id)
       {
         siteList.remove(i);
         break;
       }
   }
   writeAll(siteList);
}
public camping_sites getSite(int id)
{
     siteList= readAll();
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
    siteList= readAll();
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
    siteList= readAll();
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
     siteList= readAll();
    return siteList;
}
public ArrayList<camping_sites> readAll()
{
     BufferedReader csvReader = null;
     siteList=new ArrayList<camping_sites>();
        try {
            csvReader = new BufferedReader(new FileReader("camping_sites.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if(!data[0].equals("site_id"))
                {
                siteList.add(new camping_sites(Integer.parseInt(data[0].trim()), data[1], data[2]));}
            }
            csvReader.close();
        } catch (IOException ex) {
            Logger.getLogger(CampingSiteHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CampingSiteHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                csvReader.close();
            } catch (IOException ex) {
                Logger.getLogger(CampingSiteHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return siteList;
}
public void writeAll(ArrayList<camping_sites> sites)
{
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter("camping_sites.csv");
            csvWriter.write(" ");
            for(int i=0; i<sites.size();i++) {
                csvWriter.append(sites.get(i).getCs_id()+","+sites.get(i).getCamping_sites()+","+sites.get(i).getRegion());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CampingSiteHelper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                csvWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(CampingSiteHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
}
