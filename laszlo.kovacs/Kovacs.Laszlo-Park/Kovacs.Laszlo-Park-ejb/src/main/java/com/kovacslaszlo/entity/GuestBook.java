package com.kovacslaszlo.entity;

import com.kovacslaszlo.dto.Description;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Laci
 */
@Entity
public class GuestBook implements Serializable {

    @Id
    @GeneratedValue
    Long id;
    
    @NotNull
    @OneToOne
    private Park park;

    @ElementCollection
    private List<Description> descriptions;

    public GuestBook() {
        //constructor
    }

    public GuestBook(Park park) {
        this.park = park;
    }

    public Park getPark() {
        return park;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.park);
        hash = 17 * hash + Objects.hashCode(this.descriptions);
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
        final GuestBook other = (GuestBook) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.park, other.park)) {
            return false;
        }
        if (!Objects.equals(this.descriptions, other.descriptions)) {
            return false;
        }
        return true;
    }
}
