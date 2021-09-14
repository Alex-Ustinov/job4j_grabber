package ru.job4j.design.srp;

import java.util.Date;

public class Bread extends Food {
    Bread(String name, Date createDate, Date expiryDate, Double price, Integer discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
