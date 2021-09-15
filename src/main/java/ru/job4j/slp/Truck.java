package ru.job4j.slp;

public class Truck implements Vehicle{
    private int place;

    Truck(int place) {
        this.place = place;
    }

    @Override
    public int getPlace() {
        return this.place;
    }
}
