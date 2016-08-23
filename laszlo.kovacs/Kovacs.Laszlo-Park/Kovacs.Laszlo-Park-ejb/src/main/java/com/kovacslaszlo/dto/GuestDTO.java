package com.kovacslaszlo.dto;

/**
 *
 * @author Laci
 */
public class GuestDTO {

    private String name;
    private int age;
    private int money;

    public GuestDTO() {
        //constructor
    }

    public GuestDTO(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
