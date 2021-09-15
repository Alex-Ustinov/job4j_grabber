package ru.job4j.slp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CustomParkingTest {
    @Test
    public void testParkingVehicle() {
        Vehicle car = new Car();
        Vehicle car2 = new Car();
        Vehicle truck = new Truck(2);
        Vehicle truck2 = new Truck(3);
        Vehicle car3 = new Car();
        Vehicle car4 = new Car();
        Vehicle truck3 = new Truck(4);
        Vehicle truck4 = new Truck(2);
        Vehicle truck5 = new Truck(3);
        Vehicle car5 = new Car();

        List<Vehicle> vehicles = new ArrayList<>(List.of(
                car, car2, truck, truck2, car3, car4, truck3, truck4, truck5, car5
        ));

        Parking customParking = new CustomParking(20);
        customParking.parkingVehicle(vehicles);

        assertThat(customParking.getAmountCar(), is(5));
        assertThat(customParking.getAmountTruck(), is(5));
    }
    @Test
    public void testReport() {
        Vehicle car = new Car();
        Vehicle car2 = new Car();
        Vehicle truck = new Truck(2);
        Vehicle truck2 = new Truck(3);
        Vehicle car3 = new Car();
        Vehicle car4 = new Car();
        Vehicle truck3 = new Truck(4);
        Vehicle truck4 = new Truck(2);
        Vehicle truck5 = new Truck(3);
        Vehicle car5 = new Car();

        List<Vehicle> vehicles = new ArrayList<>(List.of(
                car, car2, truck, truck2, car3, car4, truck3, truck4, truck5, car5
        ));

        Parking customParking = new CustomParking(20);
        customParking.parkingVehicle(vehicles);

        assertThat(customParking.report(), is(
                "Amount of trucks is = 5 Amount of cars is = 5 Capacity of parking for car is 1 Capacity of parking has at list place for 0 trucks Parking is not full"));
    }
}