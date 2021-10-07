package ru.job4j.design.srp;

import java.util.List;

public class ControllQuality {

    private StoragesStore storages;

    ControllQuality (StoragesStore storages) {
        this.storages = storages;
    }

    public void sortProducts (List<Food> products) {
        for (Food product : products) {
            for (Storage storage : storages.getStorages()) {
                storage.addProduct(product);
            }
        }
    }
    public void resort() {
        for (Storage storage : storages.getStorages()) {
            sortProducts(storage.getProducts());
        }
    }
}
