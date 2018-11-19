package com.codecool.PA.controller.client;

import com.codecool.PA.model.client.Client;
import com.codecool.PA.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientController {

    private List<Client> clients = new ArrayList<>();

    public void dropOff(Client client, Vehicle vehicle) {
        if (!clients.contains(client)) clients.add(client);
        client.dropOff(vehicle);
    }

    public void receive(Client client, Vehicle vehicle) throws NoSuchElementException {
        if(clients.contains(client)) {
            try {
                client.receive(vehicle);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } else {
            throw new NoSuchElementException("You're not our client!");
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
