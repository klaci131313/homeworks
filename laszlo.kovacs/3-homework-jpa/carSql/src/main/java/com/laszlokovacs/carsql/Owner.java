package com.laszlokovacs.carsql;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Laci
 */
@Entity
public class Owner implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIME)
    private Date birthOfDate;
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_owner")
    private List<Car> carList;

    public Owner() {
        //default constructor
    }

    public Owner(Date birthOfDate, String name, List<Car> carList) {
        this.birthOfDate = birthOfDate;
        this.name = name;
        this.carList = carList;
    }

    public long getId() {
        return id;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public String getName() {
        return name;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
