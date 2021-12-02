/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent_campers.Modal;

import java.util.Date;

/**
 *
 * @author kaur
 */
public class Booking {

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    int bk_id = 0;
    int cv_id;
    int cs_id;
    Date bookingdate;
    String customerName = "";

   public Booking(int id, int cv_id, int cs_id, String customer, Date bd) {
        this.bk_id = id;
        this.cv_id = cv_id;
        this.cs_id = cs_id;
        this.customerName = customer;
        bookingdate=bd;
    }

    public int getBk_id() {
        return bk_id;
    }

    public void setBk_id(int bk_id) {
        this.bk_id = bk_id;
    }

    public int getCs_id() {
        return cs_id;
    }

    public void setCs_id(int cs_id) {
        this.cs_id = cs_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCv_id() {
        return cv_id;
    }

    public void setCv_id(int cv_id) {
        this.cv_id = cv_id;
    }

    public Booking getData(int id) {
        return new Booking(this.bk_id, this.cv_id, this.cs_id, this.customerName,this.bookingdate);
    }
}
