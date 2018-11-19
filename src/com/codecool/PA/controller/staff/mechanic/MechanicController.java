package com.codecool.PA.controller.staff.mechanic;

import com.codecool.PA.controller.staff.clerk.ClerkController;
import com.codecool.PA.model.part.Part;
import com.codecool.PA.model.staff.mechanics.Mechanic;
import com.codecool.PA.model.vehicle.Vehicle;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MechanicController {

    private List<Mechanic> mechanics = new ArrayList<>();
    private ClerkController clerkController;

    public MechanicController(ClerkController clerkController) {
        this.clerkController = clerkController;
    }

    public Mechanic findFreeMechanic() {
        for (Mechanic mechanic: mechanics) {
            if (mechanic.getVehicleToRepair() == null) {
                return mechanic;
            }
        }
        return null;
    }

    public void examine(Mechanic mechanic) throws NoSuchObjectException {
        Vehicle vehicle = mechanic.getVehicleToRepair();

        if (vehicle != null) {
            List<Part> partsNeeded = generatePartsNeeded();

            if (mechanic.getPartsNeeded().size() != 0) {
                clerkController.fetchPartsRequest(mechanic, partsNeeded);
            }
            else {
                repair(vehicle);
            }
        } else {
            throw new NoSuchObjectException("This mechanic doesn't have a vehicle to repair");
        }
    }

    private void repair(Vehicle vehicle) {
        for (Mechanic mechanic: mechanics) {
            if (mechanic.getVehicleToRepair() == vehicle && mechanic.getPartsNeeded().size() == 0) {
                mechanic.setVehicleToRepair(null);
                clerkController.returnVehicle(vehicle);
            }
        }
    }

    private List<Part> generatePartsNeeded() {
        List<Part> partsNeeded = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (new Random().nextInt(10) <= 2) {
                partsNeeded.add(new Part());
            }
        }
        return partsNeeded;
    }

}
