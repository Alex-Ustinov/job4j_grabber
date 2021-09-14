package ru.job4j.design.srp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Storage> storages;

    ControllQuality (List<Storage> storages) {
        this.storages = storages;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void sortProducts (List<Food> products) {
        for (Food product : products) {
            for (Storage storage : storages) {
                storage.addProduct(product);
            }
        }
    }
}
