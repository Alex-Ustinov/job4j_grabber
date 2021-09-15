package ru.job4j.slp;

import java.util.ArrayList;
import java.util.List;

public class CustomParking implements Parking {

    private int capacity;
    private int freePlace;
    private List<Vehicle> vehicles = new ArrayList<>();
    private int amountCar = 0;
    private int amountTruck = 0;

    CustomParking(int capacity) {
        this.capacity = capacity;
        this.freePlace = capacity;
    }

    public int getAmountCar() {
        return amountCar;
    }

    public int getAmountTruck() {
        return amountTruck;
    }

    public void setAmountCar(int amountCar) {
        this.amountCar = amountCar;
    }

    public void setAmountTruck(int amountTruck) {
        this.amountTruck = amountTruck;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void setFreePlace(int freePlace) {
        this.freePlace = freePlace;
    }

    public int getFreePlace() {
        return freePlace;
    }

    public void establishParkingData (Vehicle vehicle) {
        if (vehicle.getPlace() > 1) {
            setAmountTruck(getAmountTruck() + 1);
        } else {
            setAmountCar(getAmountCar() + 1);
        }
    }

    @Override
    public void parkingVehicle(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (getFreePlace() > vehicle.getPlace()) {
                setVehicles(vehicle);
                setFreePlace(getFreePlace() - vehicle.getPlace());
                establishParkingData(vehicle);
            } else {
                throw new IllegalArgumentException("Parking does not have enough place");
            }
        }
    }

    @Override
    public String report() {
        if (capacity == freePlace && freePlace != 0) {
            throw new IllegalArgumentException("Parking is empty");
        };
        StringBuilder report = new StringBuilder();
        report.append("Amount of trucks is = ").append(this.getAmountTruck())
                .append(" Amount of cars is = ").append(this.getAmountCar())
                .append(" Capacity of parking for car is ").append(getFreePlace())
                .append(" Capacity of parking has at list place for ").append(getFreePlace() / 2).append(" trucks")
                .append(" Parking is ").append(freePlace > 0 ? "not full" : "full");
        return report.toString();
    }

}
