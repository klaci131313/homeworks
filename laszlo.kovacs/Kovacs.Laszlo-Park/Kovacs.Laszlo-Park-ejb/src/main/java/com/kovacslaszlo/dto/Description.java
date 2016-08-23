package com.kovacslaszlo.dto;

import com.kovacslaszlo.entity.Guest;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Laci
 */
public class Description implements Serializable {

    private Date date;
    private String text;
    private Guest guest;

    public Description() {
        //constructor
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
