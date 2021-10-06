package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private StringBuilder menu;
    private List<String> menuItem = new ArrayList<>();
    private String dash = "";

    public void setMenu(StringBuilder menu) {
        this.menu = menu;
    }

    public StringBuilder getMenu() {
        return menu;
    }

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

    public List<String> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem.add(menuItem);
    }

    public void create (MenuItem item) {
        setMenuItem(getDash() + " " + item.getName());
        setDash(getDash() + "-");
        System.out.println(item.getName() + " = " + this.getDash());
        System.out.println("getSubItems size " + item.getSubItems().size());
        if (item.getSubItems().size() > 0) {
            while (item.getSubItems().size() > 0) {
                create(item.getSubItems().iterator().next());
            }
        } else {
            setDash("");
        }
    }

    public static void main(String[] args) {
        MenuItem item3 =  new MenuItem("Задача 1.1.2");
        MenuItem item4 =  new MenuItem("Задача 1.2");
        List subMenuItem2 = new ArrayList();
        subMenuItem2.add(item3);
        MenuItem item2 =  new MenuItem("Задача 1.1", subMenuItem2);
        List subMenuItem1 = new ArrayList();
        subMenuItem1.add(item2);
        subMenuItem1.add(item4);
        MenuItem item1 =  new MenuItem("Задача 1", subMenuItem1);
        List <MenuItem> menuItems = new ArrayList<>();
        menuItems.add(item1);
        menuItems.add(item2);
        menuItems.add(item3);
        menuItems.add(item4);
        Menu menu = new Menu();
        menuItems.forEach(item -> menu.create(item));
        for(String item : menu.getMenuItem()) {
            System.out.println(item);
        }
    }
}
