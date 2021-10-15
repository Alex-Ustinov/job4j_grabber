package ru.job4j.isp;

public class MenuAction implements Action {
    @Override
    public String setMenuPlace(String place, String menuName) {
        return place + " " + menuName;
    }
}
