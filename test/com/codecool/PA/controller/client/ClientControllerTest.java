package com.codecool.PA.controller.client;

import com.codecool.PA.model.client.Client;
import com.codecool.PA.model.vehicle.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ClientControllerTest {

    private Client client = new Client();
    private ClientController clientController = new ClientController();
    private Vehicle vehicle = new Vehicle();


    @Test
    public void dropOff() {
        assertFalse(clientController.getClients().contains(client));
        clientController.dropOff(client, vehicle);
        assertTrue(clientController.getClients().contains(client));
    }

    @Test
    public void receive() {
        assertThrows(NoSuchElementException.class, () -> clientController.receive(client, vehicle));
        List<Client> clients = new ArrayList<>();
        List<Vehicle> vehicles= new ArrayList<>();
        vehicles.add(vehicle);
        client.setUnavailableVehicles(vehicles);
        clients.add(client);
        clientController.setClients(clients);

        try {
            clientController.receive(client, vehicle);
        } catch (NoSuchElementException e) {
            fail("After client recive vehicle method shouldn't throw exceptions");
        }
    }
}
