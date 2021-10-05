package ru.job4j.slp;

import java.util.List;

public interface Parking {
    boolean parkingVehicle(Vehicle vehicle);
    int getAmountCar();
    int getAmountTruck();
    String report();
}
