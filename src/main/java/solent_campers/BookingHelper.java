/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent_campers;

import java.util.ArrayList;
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
    
}
