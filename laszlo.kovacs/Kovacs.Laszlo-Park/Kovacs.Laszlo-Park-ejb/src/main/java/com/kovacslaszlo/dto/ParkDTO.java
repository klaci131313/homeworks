package com.kovacslaszlo.dto;

import com.kovacslaszlo.entity.Address;

/**
 *
 * @author Laci
 */
public class ParkDTO {

    private String name;
    private Address address;
    private int capital;
    private int area;
    private int ticketPrice;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getCapital() {
        return capital;
    }

    public int getArea() {
        return area;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

}
