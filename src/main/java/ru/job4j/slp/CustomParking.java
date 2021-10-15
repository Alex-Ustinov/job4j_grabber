package ru.job4j.slp;

import java.util.ArrayList;
import java.util.List;

public class CustomParking implements Parking {

    private final int carCapacity;
    private final int truckCapacity;
    private int freePlace;
    private int freePlaceTruck;
    private int freePlaceCar;
    private final List<Vehicle> vehicles = new ArrayList<>();
    private int amountCar = 0;
    private int amountTruck = 0;

    CustomParking(int carCapacity, int truckCapacity) {
        this.carCapacity = carCapacity;
        this.truckCapacity = truckCapacity;
        this.freePlace = carCapacity + truckCapacity;
        this.freePlaceTruck = truckCapacity;
        this.freePlaceCar = carCapacity;
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

    public void setVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void establishParkingData (Vehicle vehicle) {
        if (vehicle.getPlace() > 1) {
            setAmountTruck(getAmountTruck() + 1);
        } else {
            setAmountCar(getAmountCar() + 1);
        }
        setVehicles(vehicle);
    }

    @Override
    public boolean parkingVehicle(Vehicle vehicle) {
        if (vehicle.getPlace() == 1 && getAmountCar() + 1 <= carCapacity) {
            establishParkingData(vehicle);
            return true;
        }  else if (getAmountTruck() + 1 <= truckCapacity) {
            establishParkingData(vehicle);
            return true;
        } else if (getAmountCar() + vehicle.getPlace() <= carCapacity) {
            establishParkingData(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public String report() {
        if (getAmountCar() == 0 && getAmountTruck() == 0) {
            throw new IllegalArgumentException("Parking is empty");
        }
        StringBuilder report = new StringBuilder();
        report.append("Amount of trucks is = ").append(this.getAmountTruck())
                .append(" Amount of cars is = ").append(this.getAmountCar())
                .append(" Parking is ").append((getAmountTruck() + getAmountCar()) != (carCapacity + truckCapacity) ? "not full" : "full");
        return report.toString();
    }

}
