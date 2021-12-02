/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package solent_campers;
import java.util.*; 
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
   vanlist.add(new camper_vans(1, "small","free"));
   vanlist.add(new camper_vans(2, "medium","free"));
   vanlist.add(new camper_vans(3, "large","free"));
   vanlist.add(new camper_vans(4, "small","free"));
}

public void AddVan(camper_vans cv)
{
    vanlist.add(cv);
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
}
public camper_vans getVan(int id)
{
    for(int i=0;i<vanlist.size();i++)
   {
       if(vanlist.get(i).getCv_id()==id)
         return vanlist.get(i);
   }
    return null;
}
public ArrayList<camper_vans> getAll()
{
    return vanlist;
}
}
