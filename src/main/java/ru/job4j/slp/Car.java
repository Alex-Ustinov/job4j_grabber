package ru.job4j.slp;

public class Car implements Vehicle {
    private int place = 1;

    @Override
    public int getPlace() {
        return this.place;
    }
}
