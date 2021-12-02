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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import solent_campers.Modal.Booking;

/**
 *
 * @author kaur
 */
public class BookingHelper {

    public static ArrayList<Booking> BookingList;
    
    public BookingHelper() {
     
       BookingList =new ArrayList<Booking>();
    }

    public void AddBooking(Booking cv) {
        BookingList.add(cv);
    }

    public void updateBooking(int id, Booking cv) {
        BookingList.set(id, cv);
    }

    public void deleteBooking(int id) {
        BookingList.remove(id);
    }

    public Booking getBooking(int id) {
        return BookingList.get(id);
    }

    public ArrayList<Booking> getAll() {
        return BookingList;
    }
    public ArrayList<Booking> readAll()
    {
        BufferedReader csvReader = null;
        String row="";
        BookingList=new ArrayList<Booking>();
        try {
            csvReader = new BufferedReader(new FileReader("bookings.csv"));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                if(!data[0].equals("booking_id"))
                {
                BookingList.add(new Booking(Integer.parseInt(data[0].trim()),Integer.parseInt(data[1]), 
                        Integer.parseInt(data[2]), data[3],new Date(data[4])));}
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
        return BookingList;
    }
    public void writeAll(ArrayList<Booking> bookingss)
    {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter("bookings.csv");
            csvWriter.write(" ");
            for(int i=0; i<bookingss.size();i++) {
                csvWriter.append(bookingss.get(i).getBk_id()+","
                        +bookingss.get(i).getCv_id()+","+bookingss.get(i).getCs_id()
                        +","+bookingss.get(i).getCustomerName()+","
                        +bookingss.get(i).getBookingdate());
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
