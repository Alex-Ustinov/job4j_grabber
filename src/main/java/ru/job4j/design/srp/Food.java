package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.Date;

public class Food {
    private String name;
    private Date expiryDate;
    private Date createDate;
    private Double price;
    private Integer discount;

    Food(String name, Date createDate, Date expiryDate, Double price, Integer discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getDiscount() {
        return discount;
    }
}
