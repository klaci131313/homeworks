package com.laszlokovacs.carsql;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Laci
 */
@Entity
public class PersonalCar extends Car implements Serializable {

    private String color;
    private int seats;

    public PersonalCar() {
        //default constructor
    }

    public PersonalCar(String color, int seats, String fuel,
            List<String> sparePartsList, int price, Type type) {
        super(fuel, sparePartsList, price, type);
        this.color = color;
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public int getSeats() {
        return seats;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "PersonalCar{" + "color=" + color + ", seats=" + seats + '}';
    }
}
