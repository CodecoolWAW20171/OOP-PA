package com.codecool.PA.controller.staff;

import com.codecool.PA.model.staff.Staff;
import com.codecool.PA.model.exceptions.NoPrivileges;
import com.codecool.PA.model.staff.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public class StaffController {

    private List<Staff> staff = new ArrayList<>();

    public void hire(Staff user, Staff personToHire) throws NoPrivileges {
        if (user instanceof Manager) {
            staff.add(personToHire);
        } else {
            throw new NoPrivileges();
        }
    }

    public void fire(Staff user, Staff personToFire) throws NoPrivileges {
        if (user instanceof Manager) {
            staff.remove(personToFire);
        } else {
            throw new NoPrivileges();
        }
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
