package com.codecool.PA.model.client;

import com.codecool.PA.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Client {

    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Vehicle> unavailableVehicles = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getUnavailableVehicles() {
        return unavailableVehicles;
    }

    public void setUnavailableVehicles(List<Vehicle> unavailableVehicles) {
        this.unavailableVehicles = unavailableVehicles;
    }

    public void dropOff(Vehicle vehicle) {
        vehicles.remove(vehicle);
        unavailableVehicles.add(vehicle);
    }

    public void receive(Vehicle vehicle) throws NoSuchElementException {
        if (unavailableVehicles.contains(vehicle)) {
            unavailableVehicles.remove(vehicle);
            vehicles.add(vehicle);
        } else {
            throw new NoSuchElementException("Man it's not my car!");
        }
    }

}
