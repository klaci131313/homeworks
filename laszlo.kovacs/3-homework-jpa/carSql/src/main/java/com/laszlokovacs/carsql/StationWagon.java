package com.laszlokovacs.carsql;

import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Laci
 */
@Entity
public class StationWagon extends PersonalCar {

    private int numberOfDoors;

    public StationWagon() {
        //default constructor
    }

    public StationWagon(int numberOfDoors, String color, int seats, String fuel,
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
