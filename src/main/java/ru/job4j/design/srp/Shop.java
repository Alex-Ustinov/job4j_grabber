package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop implements Storage {

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

    public void setDiscount(Food product) {
        product.setDiscount(50.0);
        product.setPrice((product.getDiscount() / 100) * product.getPrice());
    }

    @Override
    public boolean checkProduct(Food product) {
        long percentExpire =  rateExpire(product);
        if (percentExpire < 0) {
            return false;
        } else if (percentExpire >= 25 && percentExpire < 75) {
            return true;
        }  else if (percentExpire > 75 && percentExpire < 100) {
            setDiscount(product);
            return true;
        }
        return false;
    }
}
