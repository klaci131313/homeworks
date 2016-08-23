package com.kovacslaszlo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Laci
 */
@Entity
public class Park implements Serializable {

    @Id
    @GeneratedValue()
    private Long id;

    @NotNull
    @Column(name = "park_name")
    private String name;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @NotNull
    @Column(name = "park_capital")
    private int capital;

    @NotNull
    @Column(name = "park_area")
    private int area;

    @NotNull
    @Column(name = "ticketprice")
    private int ticketPrice;

    @OneToMany(mappedBy = "park")
    private List<Machine> machines;

    @OneToMany(mappedBy = "park")
    private List<Guest> guests;

    public Park() {
        //constructor
    }

    public Park(String name, Address address, int capital, int area, int ticketPrice) {
        this.name = name;
        this.address = address;
        this.capital = capital;
        this.area = area;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Park other = (Park) obj;
        if (this.capital != other.capital) {
            return false;
        }
        if (this.area != other.area) {
            return false;
        }
        if (this.ticketPrice != other.ticketPrice) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.machines, other.machines)) {
            return false;
        }
        if (!Objects.equals(this.guests, other.guests)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.address);
        hash = 71 * hash + this.capital;
        hash = 71 * hash + this.area;
        hash = 71 * hash + this.ticketPrice;
        hash = 71 * hash + Objects.hashCode(this.machines);
        hash = 71 * hash + Objects.hashCode(this.guests);
        return hash;
    }
}
