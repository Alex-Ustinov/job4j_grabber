package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Food> allFood = storages.stream().flatMap(storage -> storage.getProducts().stream()).collect(Collectors.toList());
        storages.forEach(storage -> storage.getProducts().clear());
        sortProducts(allFood);
    }
}
