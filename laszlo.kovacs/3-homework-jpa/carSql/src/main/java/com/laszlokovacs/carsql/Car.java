package com.laszlokovacs.carsql;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Laci
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({
    @NamedQuery(
            name = "Car.findCar",
            query = "SELECT b FROM Car b WHERE b.type=:param1"
    ),
    @NamedQuery(
            name = "Car.findExpensiveCars",
            query = "SELECT b FROM Car b WHERE b.price>:param2"
    )
})
public class Car extends Vehicle implements Serializable {

    protected String fuel;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "spare_parts")
    @Column(name = "part")
    protected List<String> sparePartsList;

    public Car() {
        //default constructor
    }

    public Car(String fuel) {
        this.fuel = fuel;
    }

    public Car(String fuel, List<String> sparePartsList, int price, Type type) {
        super(price, type);
        this.fuel = fuel;
        this.sparePartsList = sparePartsList;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
