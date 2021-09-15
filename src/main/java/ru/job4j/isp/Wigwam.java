package ru.job4j.isp;

public class Wigwam implements Building {
    @Override
    public void setWindow() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setWalls() {
        System.out.println("It has one roof");
    }

    @Override
    public void setRoof() {
        throw new UnsupportedOperationException();
    }
}
