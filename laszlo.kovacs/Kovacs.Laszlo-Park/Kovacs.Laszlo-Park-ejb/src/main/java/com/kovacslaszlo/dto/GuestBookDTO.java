package com.kovacslaszlo.dto;

import com.kovacslaszlo.entity.Park;

/**
 *
 * @author Laci
 */
public class GuestBookDTO {

    private Park park;

    public GuestBookDTO() {
        //constructor
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }
}
