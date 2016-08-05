package com.laszlokovacs.carsql;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Laci
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "Camion.findNumberOfSeats",
            query = "SELECT b FROM Camion b WHERE b.seats=:param3"
    ),
    @NamedQuery(
            name = "Camion.findWithTrailer",
            query = "SELECT b FROM Camion b WHERE b.trailer=:param4"
    )
})
public class Camion extends Car implements Serializable {

    private boolean trailer;
    private int seats;

    public Camion() {
        //default constructor
    }
    
    

    public Camion(boolean trailer, int seats, String fuel,
            List<String> sparePartsList, int price, Type type) {
        super(fuel, sparePartsList, price, type);

        this.trailer = trailer;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    public boolean isTrailer() {
        return trailer;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
