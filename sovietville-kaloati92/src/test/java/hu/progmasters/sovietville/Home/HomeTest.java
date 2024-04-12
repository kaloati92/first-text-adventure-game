package hu.progmasters.sovietville.Home;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeTest {

    @Test
    void testCreateYoungCouple() {
        Home home = new Home();

        assertEquals(0, home.getPeople().size());
        assertEquals(0, home.getDevices().size());
        assertEquals(0, home.getRooms().size());

        home.createYoungCouple(25, 30);

        assertEquals(2, home.getPeople().size());
        assertEquals(4, home.getDevices().size());
        assertEquals(2, home.getRooms().size());
    }

    @Test
    void testCreateYoungSingle() {
        Home home = new Home();

        assertEquals(0, home.getPeople().size());
        assertEquals(0, home.getDevices().size());
        assertEquals(0, home.getRooms().size());

        home.createYoungSingle(25);

        assertEquals(1, home.getPeople().size());
        assertEquals(1, home.getDevices().size());
        assertEquals(1, home.getRooms().size());
    }

    @Test
    void testCreateOldCouple() {
        Home home = new Home();

        assertEquals(0, home.getPeople().size());
        assertEquals(0, home.getDevices().size());
        assertEquals(0, home.getRooms().size());

        home.createOldCouple(25, 30);

        assertEquals(2, home.getPeople().size());
        assertEquals(3, home.getDevices().size());
        assertEquals(3, home.getRooms().size());
    }

    @Test
    void testCreateOldSingle() {
        Home home = new Home();

        assertEquals(0, home.getPeople().size());
        assertEquals(0, home.getDevices().size());
        assertEquals(0, home.getRooms().size());

        home.createOldSingle(30);

        assertEquals(1, home.getPeople().size());
        assertEquals(1, home.getDevices().size());
        assertEquals(1, home.getRooms().size());
    }

    @Test
    void testGetSalary() {
        Home home = new Home();
        home.createYoungCouple(33, 44);

        assertEquals(77, home.getSalary());
    }

    @Test
    void testGetElectricityCost() {
        Home home = new Home();
        home.createOldCouple(21, 19);

        assertEquals(45 + 3.7, home.getElectricityCost());
    }

    @Test
    void testGetPeopleFromHome() {
        Home home = new Home();
        home.createOldSingle(11);

        assertEquals(1, home.getPeopleFromHome());
    }

    @Test
    void testPayDay_And_BillDay() {
        Home home = new Home();
        home.createOldCouple(33, 33);

        assertEquals(0, home.getMoney());

        home.payDay();

        assertEquals(66, home.getMoney());

        home.billDay();

        assertEquals(66 - 48.7, home.getMoney());
    }
}
