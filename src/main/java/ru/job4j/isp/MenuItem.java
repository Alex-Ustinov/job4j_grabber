package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String name;
    private List<MenuItem> subItems = new ArrayList<>();
    private Action action = new MenuAction();

    MenuItem(String name, List<MenuItem> subItems) {
        subItems.forEach(item -> this.subItems.add(item));
        this.name = name;
    }

    public String getMenuItemStructure(String place) {
        return action.setMenuPlace(place, name);
    };

    MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getSubItems() {
        return subItems;
    }
}
