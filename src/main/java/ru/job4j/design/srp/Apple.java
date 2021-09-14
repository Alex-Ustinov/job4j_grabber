package ru.job4j.design.srp;

import java.util.Date;

public class Apple extends Food {
    Apple(String name, Date createDate,  Date expiryDate, Double price, Double discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
