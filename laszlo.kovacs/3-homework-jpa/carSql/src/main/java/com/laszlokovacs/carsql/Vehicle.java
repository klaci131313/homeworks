package com.laszlokovacs.carsql;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Laci
 */
@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue
    @Column(name = "lpn")
    protected long id;
    protected int price;
    @Enumerated(EnumType.STRING)
    protected Type type;

    public Vehicle() {
        //default constructor
    }

    public Vehicle(int price, Type type) {
        this.price = price;
        this.type = type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", price=" + price
                + ", type=" + type + '}';
    }
}
