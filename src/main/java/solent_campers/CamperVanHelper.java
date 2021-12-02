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
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import solent_campers.Modal.camper_vans;


 
/**
 *
 * @author kaur
 */
public class CamperVanHelper {

public static ArrayList<camper_vans> vanlist;

public CamperVanHelper()
{
   vanlist =new ArrayList<camper_vans>();
   readAll();
}

public void AddVan(camper_vans cv)
{
    readAll();
    vanlist.add(cv);
    writeAll(vanlist);
}

public void updateVan(int id,camper_vans cv)
{
    vanlist.set(id,cv);
}
public void deleteVan(int id)
{
    for(int i=0;i<vanlist.size();i++)
   {
       if(vanlist.get(i).getCv_id()==id)
         vanlist.remove(i);
   }
    writeAll(vanlist);
}
public camper_vans getVan(int id)
{
    readAll();
    for(int i=0;i<vanlist.size();i++)
   {
       if(vanlist.get(i).getCv_id()==id)
         return vanlist.get(i);
   }
    return null;
}
public ArrayList<camper_vans> getAll()
{
    readAll();
    return vanlist;
}
public ArrayList<camper_vans> readAll()
{
     BufferedReader csvReader = null;
     String row="";
     vanlist=new ArrayList<camper_vans>();
        try {
            csvReader = new BufferedReader(new FileReader("camper_vans.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if(!data[0].equals("vanID"))
                {
                vanlist.add(new camper_vans(Integer.parseInt(data[0].trim()), data[1], data[2]));}
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
        return vanlist;
}
public void writeAll(ArrayList<camper_vans> vans)
{
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter("camper_vans.csv");
            csvWriter.write(" ");
            for(int i=0; i<vans.size();i++) {
                csvWriter.append(vans.get(i).getCv_id()+","+vans.get(i).getType()+","+vans.get(i).getStatus());
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
