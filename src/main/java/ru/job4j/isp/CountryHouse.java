package ru.job4j.isp;

public class CountryHouse implements Building {

    @Override
    public void setWindow() {
        System.out.println("This house has 4 windows");
    }

    @Override
    public void setWalls() {
        System.out.println("This house has 4 walls");
    }

    @Override
    public void setRoof() {
        System.out.println("This house has 1 roof");
    }
}
