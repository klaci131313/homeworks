package com.kovacslaszlo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Laci
 */
@Entity
public class Guest implements Serializable  {

    @Id
    @GeneratedValue()
    private Long id;
    
    @NotNull
    private String name;
    
    @NotNull
    private int age;
    
    @NotNull
    private boolean active;
    
    @NotNull
    private int money;   
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entryDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    private Machine machine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "park_id", referencedColumnName = "id")
    private Park park;

    public Guest() {
        //constructor
    }

    public Guest(String name, int age, boolean active, int money) {
        this.name = name;
        this.age = age;
        this.active = active;
        this.money = money;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + this.age;
        hash = 13 * hash + (this.active ? 1 : 0);
        hash = 13 * hash + this.money;
        hash = 13 * hash + Objects.hashCode(this.entryDate);
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
        final Guest other = (Guest) obj;
        if (this.age != other.age) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (this.money != other.money) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.entryDate, other.entryDate)) {
            return false;
        }
        return true;
    }
}
