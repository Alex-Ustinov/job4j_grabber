package ru.job4j.design.srp;

import java.util.List;

public class CustomStorageStore implements StoragesStore {

    private List<Storage> storage;

    CustomStorageStore(List<Storage> storage) {
        this.storage = storage;
    }

    @Override
    public List<Storage> getStorages() {
        return storage;
    }
}
