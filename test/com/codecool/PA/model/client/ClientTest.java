package com.codecool.PA.model.client;

import com.codecool.PA.model.vehicle.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    private Client client = new Client();
    private List<Vehicle> vehicleList = new ArrayList<>();
    private Vehicle vehicle = new Vehicle();

    @Test
    public void dropOff() {
        vehicleList.add(vehicle);
        client.setVehicles(vehicleList);
        assertTrue(client.getVehicles().contains(vehicle));
    }

    @Test
    public void receive() {
        assertFalse(client.getUnavailableVehicles().contains(vehicle));
        assertThrows(NoSuchElementException.class, () -> client.receive(vehicle));

        try {
            if (!vehicleList.contains(vehicle)) vehicleList.add(vehicle);
            client.setUnavailableVehicles(vehicleList);
            client.receive(vehicle);
            assertFalse(client.getUnavailableVehicles().contains(vehicle));
            assertTrue(client.getVehicles().contains(vehicle));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
