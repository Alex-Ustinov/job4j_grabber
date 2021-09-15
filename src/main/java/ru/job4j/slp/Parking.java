package ru.job4j.slp;

import java.util.List;

public interface Parking {
    void setCapacity(int capacity);
    void parkingVehicle(List<Vehicle> vehicles);
    int getAmountCar();
    int getAmountTruck();
    String report();
}
