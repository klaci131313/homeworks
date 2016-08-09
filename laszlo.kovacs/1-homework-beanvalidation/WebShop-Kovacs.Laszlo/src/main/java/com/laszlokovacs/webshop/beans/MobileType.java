package com.laszlokovacs.webshop.beans;

import com.laszlokovacs.webshop.constraint.CustomColor;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.laszlokovacs.webshop.annotations.DTOQualifier;

/**
 *
 * @author Laci
 */
@CustomColor
@DTOQualifier
public class MobileType {

    @NotNull
    @Size(min = 36, max = 36)
    private String id;

    @NotNull
    private Manufacturer manufacturer;

    @Size(min = 3)
    @NotNull
    private String type;

    @NotNull
    @Min(0)
    private Integer price;

    @NotNull
    private Currency currency;

    @NotNull
    private Color color;

    public MobileType() {
        //Do nothing because JSON
    }

    public MobileType(String id, Manufacturer manufacturer, String type,
            Integer price, Currency currency, Color color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.currency = currency;
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.manufacturer);
        hash = 31 * hash + Objects.hashCode(this.type);
        hash = 31 * hash + Objects.hashCode(this.price);
        hash = 31 * hash + Objects.hashCode(this.currency);
        hash = 31 * hash + Objects.hashCode(this.color);
        return hash;
    }

    public String getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Color getColor() {
        return color;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final MobileType other = (MobileType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.manufacturer != other.manufacturer) {
            return false;
        }
        return this.color == other.color;
    }
}
