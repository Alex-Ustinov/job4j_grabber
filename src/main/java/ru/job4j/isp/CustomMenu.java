package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class CustomMenu implements Menu, PrintMenu {
    private List<String> menuItem = new ArrayList<>();

    public List<String> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem.add(menuItem);
    }

    @Override
    public void create (MenuItem item, String dash) {
        setMenuItem(item.getMenuItemStructure(dash));
        if (item.getSubItems().size() > 0) {
            for (MenuItem subItem : item.getSubItems()) {
                create(subItem, dash + "-");
            }
        }
    }

    @Override
    public String createViewMenu (List<String> menu) {
        String rsl = "";
        for (String item : menu) {
            rsl = rsl+System.lineSeparator()+item;
        }
        return rsl;
    }

    @Override
    public void print(String menu) {
        System.out.println(menu);
    }

    public static void main(String[] args) {
        MenuItem item8 =  new MenuItem("Задача 2.1");
        List subMenuItem4 = new ArrayList();
        subMenuItem4.add(item8);
        MenuItem item7 =  new MenuItem("Задача 2", subMenuItem4);
        MenuItem item6 =  new MenuItem("Задача 1.1.1.1");
        List subMenuItem3 = new ArrayList();
        subMenuItem3.add(item6);
        MenuItem item5 =  new MenuItem("Задача 1.1.1", subMenuItem3);
        MenuItem item3 =  new MenuItem("Задача 1.1.2");
        MenuItem item4 =  new MenuItem("Задача 1.2");
        List subMenuItem2 = new ArrayList();
        subMenuItem2.add(item5);
        subMenuItem2.add(item3);
        MenuItem item2 =  new MenuItem("Задача 1.1", subMenuItem2);
        List subMenuItem1 = new ArrayList();
        subMenuItem1.add(item2);
        subMenuItem1.add(item4);
        MenuItem item1 =  new MenuItem("Задача 1", subMenuItem1);
        List <MenuItem> menuItems = new ArrayList<>();
        menuItems.add(item1);
        menuItems.add(item7);
        CustomMenu menu = new CustomMenu();
        menuItems.forEach(item -> menu.create(item, ""));
        String view = menu.createViewMenu(menu.getMenuItem());
        menu.print(view);

    }
}
