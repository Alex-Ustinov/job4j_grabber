package ru.job4j.design.srp;

public class Track extends Car {
    private int whiles;

    @Override
    public void setWhiles(int whiles) {
        this.whiles = whiles;
    }

    @Override
    public int getWhiles() {
        return whiles * 2;
    }
}
