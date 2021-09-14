package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;

public interface Storage {
    List<Food> getProducts();
    boolean checkProduct(Food product);
    boolean addProduct(Food product);
}
