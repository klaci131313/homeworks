package com.kovacslaszlo.dto;

import com.kovacslaszlo.enums.MachineType;

/**
 *
 * @author Laci
 */
public class MachineDTO {

    private String name;
    private int size;
    private int price;
    private int ticketPrice;
    private int capacity;
    private MachineType type;
    private int minimumAge;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public MachineType getType() {
        return type;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }



}
