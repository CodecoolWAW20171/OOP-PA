package com.codecool.PA.controller.staff;

import com.codecool.PA.model.staff.Staff;
import com.codecool.PA.model.staff.clerk.Clerk;
import com.codecool.PA.model.exceptions.NoPrivileges;
import com.codecool.PA.model.staff.manager.Manager;
import com.codecool.PA.model.staff.mechanics.Mechanic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StaffControllerTest {

    private StaffController staffController = new StaffController();
    private Manager manager = new Manager();
    private Staff staff = new Staff();

    @Test
    public void hire() {
        assertThrows(NoPrivileges.class, () -> staffController.hire(new Clerk(), manager));
        assertThrows(NoPrivileges.class, () -> staffController.hire(new Mechanic(), manager));
        assertThrows(NoPrivileges.class, () -> staffController.hire(staff, manager));

        try {
            assertEquals(0, staffController.getStaff().size());
            staffController.hire(manager, staff);
            assertEquals(staff, staffController.getStaff().get(0));
        } catch (NoPrivileges e) {
            e.printStackTrace();
            System.out.println("Manager can add new staff member.");
        }
    }

    @Test
    public void fire() {
        assertThrows(NoPrivileges.class, () -> staffController.fire(new Clerk(), manager));
        assertThrows(NoPrivileges.class, () -> staffController.fire(new Mechanic(), manager));
        assertThrows(NoPrivileges.class, () -> staffController.fire(staff, manager));

        List<Staff> staffList = new ArrayList<>();
        staffList.add(staff);
        staffController.setStaff(staffList);

        try {
            assertEquals(staffList, staffController.getStaff());
            assertTrue(staffController.getStaff().contains(staff));
            staffController.fire(manager, staff);
            assertFalse(staffController.getStaff().contains(staff));
        } catch (NoPrivileges e) {
            e.printStackTrace();
            System.out.println("Manager can fire staff member.");
        }

    }
}
