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

    public void setFreePlaceTruck(int freePlaceTruck) {
        this.freePlaceTruck = freePlaceTruck;
    }

    public int getFreePlaceTruck() {
        return freePlaceTruck;
    }

    public void setFreePlaceCar(int freePlaceCar) {
        this.freePlaceCar = freePlaceCar;
    }

    public int getFreePlaceCar() {
        return freePlaceCar;
    }

    @Override
    public boolean parkingVehicle(Vehicle vehicle) {
        if (vehicle.getPlace() == 1 && getAmountCar() + 1 <= carCapacity) {
            setVehicles(vehicle);
            setFreePlace(getFreePlace() - 1);
            setFreePlaceCar(getFreePlaceCar() - 1);
            establishParkingData(vehicle);
            return true;
        } else if (getFreePlace() - vehicle.getPlace() >= 0) {
            if (getFreePlaceTruck() - vehicle.getPlace() >= 0) {
                setFreePlaceTruck(getFreePlaceTruck() - vehicle.getPlace());
            } else {
                setFreePlaceCar(Math.max(0, getFreePlaceCar() - vehicle.getPlace()));
                setFreePlaceTruck(getFreePlaceTruck() - Math.abs((getFreePlaceCar() - vehicle.getPlace())));
            }
            setVehicles(vehicle);
            setFreePlace(getFreePlace() - vehicle.getPlace());
            establishParkingData(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public String report() {
        if (carCapacity + truckCapacity == freePlace && freePlace != 0) {
            throw new IllegalArgumentException("Parking is empty");
        }
        StringBuilder report = new StringBuilder();
        report.append("Amount of trucks is = ").append(this.getAmountTruck())
                .append(" Amount of cars is = ").append(this.getAmountCar())
                .append(" Capacity of parking for car is ").append(getFreePlace())
                .append(" Capacity of parking has at list place for ").append(getFreePlace() / 2).append(" trucks")
                .append(" Parking is ").append(freePlace > 0 ? "not full" : "full");
        return report.toString();
    }

}
