package ru.job4j.design.srp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> products = new ArrayList<>();

    public List<Food> getProducts() {
        return products;
    }

    @Override
    public boolean addProduct (Food product) {
        Boolean checkResult = checkProduct(product);
        if (checkResult) {
            products.add(product);
        }
        return checkResult;

    }

    @Override
    public boolean checkProduct(Food product) {
        long percentExpire = rateExpire(product);
        if (percentExpire < 0 || percentExpire < 25) {
            return false;
        }
        System.out.println(product.getName()+ " " + percentExpire);
        return true;
    }
}
