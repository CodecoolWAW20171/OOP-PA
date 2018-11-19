package com.codecool.PA.controller.staff.clerk;

import com.codecool.PA.controller.client.ClientController;
import com.codecool.PA.controller.staff.mechanic.MechanicController;
import com.codecool.PA.model.client.Client;
import com.codecool.PA.model.part.Part;
import com.codecool.PA.model.staff.clerk.Clerk;
import com.codecool.PA.model.staff.mechanics.Mechanic;
import com.codecool.PA.model.vehicle.Vehicle;

import java.util.*;

public class ClerkController {

    private List<Clerk> clerks = new ArrayList<>();
    private Deque<Vehicle> vehiclesToAssociate = new LinkedList<>();
    private Map<Vehicle, Client> vehiclesInGarage = new HashMap<>();

    public void receive(Client client, Vehicle vehicle, Mechanic mechanic) {
        vehiclesInGarage.put(vehicle, client);
        vehiclesToAssociate.add(vehicle);

        if (mechanic != null) {
            associate(mechanic);
        }
    }

    public void associate(Mechanic mechanic) {
        if (vehiclesToAssociate.size() != 0) {
            mechanic.setVehicleToRepair(vehiclesToAssociate.getFirst());
            vehiclesToAssociate.removeFirst();
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        if (vehiclesInGarage.containsKey(vehicle)) {
            try {
                clientController.receive(vehiclesInGarage.get(vehicle), vehicle);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            throw new NoSuchElementException("We don't have this vehicle.");
        }
    }

    public void fetchPartsRequest(Mechanic mechanic, List<Part> partsNeeded) {
        clerks.get(new Random().nextInt(clerks.size())).addPartsToOrder(mechanic, partsNeeded);
    }

    public void orderParts(Clerk clerk, Mechanic mechanic) {
        clerk.removePartsToOrder(mechanic);
    }
}
