package hu.progmasters.sovietville.Home;

import hu.progmasters.sovietville.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Person> people = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private double money;

    public Home() {
    }

    public void createYoungCouple(double income1, double income2) {
        rooms.add(new Room(20));
        rooms.add(new Room(20));

        devices.add(Device.TV);
        devices.add(Device.FRIDGE);
        devices.add(Device.COMPUTER);
        devices.add(Device.COMPUTER);

        people.add(new Person(income1));
        people.add(new Person(income2));
    }
    public void createYoungSingle(double income1){
        rooms.add(new Room(10));

        devices.add(Device.COMPUTER);

        people.add(new Person(income1));
    }
    public void createOldCouple(double income1, double income2){
        rooms.add(new Room(15));
        rooms.add(new Room(15));
        rooms.add(new Room(15));

        devices.add(Device.TV);
        devices.add(Device.FRIDGE);
        devices.add(Device.STOVE);

        people.add(new Person(income1));
        people.add(new Person(income2));
    }
    public void createOldSingle(double income1){
        rooms.add(new Room(15));

        devices.add(Device.STOVE);

        people.add(new Person(income1));
    }
    public double getSalary() {
        double homeSalary = 0;
        for (Person person : people) {
            homeSalary += person.getSalary();
        }
        return homeSalary;
    }

    private double getDeviceElectricityCost() {
        double deviceElectricityCost = 0;
        for (Device device : devices) {
            deviceElectricityCost += device.electricityCost;
        }
        return deviceElectricityCost;
    }

    private double getRoomElectricityCost() {
        double homeElecricityCost = 0;
        for (Room room : rooms) {
            homeElecricityCost += room.getElectricityCost();
        }
        return homeElecricityCost;
    }
    public double getElectricityCost(){
        return getDeviceElectricityCost() + getRoomElectricityCost();
    }

    public int getPeopleFromHome() {
        int count = 0;
        for (Person person : people) {
            count++;
        }
        return count;
    }

    public void billDay() {
        money -= getElectricityCost();
    }

    public void payDay() {
        money += getSalary();
    }

    public double getMoney() {
        return money;
    }

    public List<Person> getPeople() {
        return List.copyOf(people);
    }

    public List<Room> getRooms() {
        return List.copyOf(rooms);
    }

    public List<Device> getDevices() {
        return List.copyOf(devices);
    }
}
