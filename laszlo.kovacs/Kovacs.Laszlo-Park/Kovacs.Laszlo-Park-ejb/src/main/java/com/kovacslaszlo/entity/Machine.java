package com.kovacslaszlo.entity;

import com.kovacslaszlo.enums.MachineType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Laci
 */
@Entity
public class Machine implements Serializable {

    @Id
    @GeneratedValue()
    private Long id;

    @NotNull
    @Column(name = "machine_name")
    private String name;

    @NotNull
    @Column(name = "machine_size")
    private int size;

    @NotNull
    @Column(name = "machine_price")
    private int price;

    @NotNull
    @Column(name = "machine_ticketprice")
    private int ticketPrice;

    @NotNull
    @Column(name = "machine_capacity")
    private int capacity;

    @NotNull
    @Column(name = "machine_type")
    @Enumerated
    private MachineType type;

    @NotNull
    @Column(name = "minimum_age")
    private int minimumAge;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "park_id", referencedColumnName = "id")
    private Park park;

    @OneToMany(mappedBy = "machine")
    private List<Guest> guests;

    public Machine() {
        //constructor
    }

    public Machine(String name, int size, int price, int ticketPrice,
            int capacity, MachineType type, int minimumAge) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.ticketPrice = ticketPrice;
        this.capacity = capacity;
        this.type = type;
        this.minimumAge = minimumAge;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int sharePrice) {
        this.price = sharePrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public MachineType getType() {
        return type;
    }

    public void setType(MachineType type) {
        this.type = type;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.size;
        hash = 89 * hash + this.price;
        hash = 89 * hash + this.ticketPrice;
        hash = 89 * hash + this.capacity;
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + this.minimumAge;
        hash = 89 * hash + (this.active ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.park);
        hash = 89 * hash + Objects.hashCode(this.guests);
        return hash;
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
        final Machine other = (Machine) obj;
        if (this.size != other.size) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.ticketPrice != other.ticketPrice) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.minimumAge != other.minimumAge) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.park, other.park)) {
            return false;
        }
        if (!Objects.equals(this.guests, other.guests)) {
            return false;
        }
        return true;
    }
}
