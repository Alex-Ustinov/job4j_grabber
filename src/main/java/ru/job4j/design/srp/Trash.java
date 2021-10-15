package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trash implements Storage {

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
    public long rateExpire(Food product) {
        return 0;
    }

    @Override
    public boolean checkProduct(Food product) {
        long now = new Date().getTime();
        long leftTime = product.getExpiryDate().getTime() - now;
        if (leftTime < 0) {
            return true;
        }
        return false;
    }
}
