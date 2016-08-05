package com.laszlokovacs.carsql;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author Laci
 */
@Entity
@NamedQuery(
        name = "Sedan.findDoors",
        query = "SELECT b FROM Sedan b WHERE b.numberOfDoors=:param5"
)
public class Sedan extends PersonalCar {

    private int numberOfDoors;

    public Sedan() {
        //default constructor
    }

    public Sedan(int numberOfDoors, String color, int seats, String fuel,
            List<String> sparePartsList, int price, Type type) {
        super(color, seats, fuel, sparePartsList, price, type);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
