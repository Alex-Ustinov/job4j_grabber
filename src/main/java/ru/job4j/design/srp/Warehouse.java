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

    public long rateExpire(Food product){
        long now = new Date().getTime();
        long difference = product.getExpiryDate().getTime() - product.getCreateDate().getTime();
        long leftTime = product.getExpiryDate().getTime() - now;
        if (leftTime < 0) {
            return -1;
        }
        long pastTime = now - product.getCreateDate().getTime();
        return pastTime * 100 / difference;
    }

    @Override
    public boolean checkProduct(Food product) {
        long percentExpire = rateExpire(product);
        if (percentExpire < 0) {
            return false;
        } else if (percentExpire >= 25) {
            return false;
        }
        return true;
    }
}
