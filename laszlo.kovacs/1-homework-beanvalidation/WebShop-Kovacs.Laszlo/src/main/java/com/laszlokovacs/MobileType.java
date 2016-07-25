/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laszlokovacs;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Laci
 */
//@CustomColor
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
    private int price;

    @NotNull
    private Currency currency;

    @NotNull
    private Color color;

    public MobileType() {
        //Do nothing because JSON
    }

    public MobileType(String id, Manufacturer manufacturer, String type, int price, Currency currency, Color color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.currency = currency;
        this.color = color;
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

    public int getPrice() {
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
}
