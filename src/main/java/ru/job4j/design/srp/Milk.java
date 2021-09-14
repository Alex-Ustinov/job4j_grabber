package ru.job4j.design.srp;

import java.util.Date;

public class Milk extends Food {

    Milk(String name, Date createDate, Date expiryDate, Double price, Double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
