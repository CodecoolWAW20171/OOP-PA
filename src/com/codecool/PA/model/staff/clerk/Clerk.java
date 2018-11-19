package com.codecool.PA.model.staff.clerk;

import com.codecool.PA.model.part.Part;
import com.codecool.PA.model.staff.Staff;
import com.codecool.PA.model.staff.mechanics.Mechanic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clerk extends Staff {

    private Map<Mechanic, List<Part>> partsToOrder = new HashMap<>();

    public void addPartsToOrder(Mechanic mechanic, List<Part> parts) {
        if (partsToOrder.containsKey(mechanic)) {
            parts.addAll(partsToOrder.get(mechanic));
            partsToOrder.replace(mechanic, parts);
        } else {
            partsToOrder.put(mechanic, parts);
        }
    }

    public void removePartsToOrder(Mechanic mechanic) {
        partsToOrder.remove(mechanic);
    }
}
