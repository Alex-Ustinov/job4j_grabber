package ru.job4j.isp;

import java.util.ArrayList;

public class MenuItem {
    private String name;
    private ArrayList<MenuItem> subItems;

    public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getSubItems() {
        return subItems;
    }
}
