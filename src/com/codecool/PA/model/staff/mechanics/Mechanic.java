package com.codecool.PA.model.staff.mechanics;

import com.codecool.PA.model.part.Part;
import com.codecool.PA.model.staff.Staff;
import com.codecool.PA.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Mechanic extends Staff {

    private Vehicle vehicleToRepair;
    private List<Part> partsNeeded = new ArrayList<>();

    public Vehicle getVehicleToRepair() {
        return vehicleToRepair;
    }

    public void setVehicleToRepair(Vehicle vehicleToRepair) {
        this.vehicleToRepair = vehicleToRepair;
    }

    public List<Part> getPartsNeeded() {
        return partsNeeded;
    }

    public void setPartsNeeded(List<Part> partsNeeded) {
        this.partsNeeded = partsNeeded;
    }
}
