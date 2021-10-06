package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String name;
    private ArrayList<MenuItem> subItems = new ArrayList<>();

    MenuItem(String name, List<MenuItem> subItems) {
        subItems.forEach(item -> this.subItems.add(item));
        this.name = name;
    }

    MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getSubItems() {
        return subItems;
    }
}
