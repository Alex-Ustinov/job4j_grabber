package ru.job4j.isp;

import java.util.List;

public class Menu {
    private StringBuilder menu;
    private String dash;

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

    public void create (List<MenuItem> items) {
        for(MenuItem item : items) {

            if (item.getSubItems().size() > 0) {
                create(item.getSubItems());
            }
        }
    }
}
