package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Storage {
    List<Food> getProducts();
    boolean checkProduct(Food product);
    boolean addProduct(Food product);
    default long rateExpire(Food product){
        long now = new Date().getTime();
        long difference = product.getExpiryDate().getTime() - product.getCreateDate().getTime();
        long leftTime = product.getExpiryDate().getTime() - now;
        if (leftTime < 0) {
            return -1;
        }
        long pastTime = now - product.getCreateDate().getTime();
        return pastTime * 100 / difference;
    }
}
