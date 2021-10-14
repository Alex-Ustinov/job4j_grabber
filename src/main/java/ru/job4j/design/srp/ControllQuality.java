package ru.job4j.design.srp;

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

    public void resort() {
        List<Storage> copy = new ArrayList<>(storages);
        storages.clear();
        for (Storage storage : copy) {
            sortProducts(storage.getProducts());
        }
    }
}
