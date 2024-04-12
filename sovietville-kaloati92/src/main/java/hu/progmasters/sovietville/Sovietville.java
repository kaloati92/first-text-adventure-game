package hu.progmasters.sovietville;

import hu.progmasters.sovietville.Home.Home;

import java.util.ArrayList;
import java.util.List;

public class Sovietville {
    private List<Home> homes = new ArrayList<>();


    public void villeRunner(String input) {
        String inputWithoutWhiteSpace = input.replaceAll("\\s+", "").replace(")", "");
        Home home = new Home();

        String[] inputArray = input.split("\\(");
        switch (inputArray[0]) {
            case "quit":
                System.out.println(quit());
                break;
            case "status":
                System.out.println(status());
                break;
            case "bills":
                bills();
                break;
            default:
                registerHome(inputWithoutWhiteSpace, home);
                break;
        }
    }

    private void registerHome(String input, Home home) {
        String[] inputCommand = input.split("\\(");
        String[] salary = inputCommand[1].split(",");
        switch (inputCommand[0]) {
            case "YoungCouple":
                addYoungCoupleHome(salary[0], salary[1], home);
                break;
            case "YoungSingle":
                addYoungSingle(salary[0], home);
                break;
            case "OldCouple":
                addOldCouple(salary[0], salary[1], home);
                break;
            case "OldSingle":
                addOldSingle(salary[0], home);
                break;
        }
    }

    private void addOldSingle(String s, Home home) {
        try {
            home.createOldSingle(Double.parseDouble(s));
            homes.add(home);
        } catch (NumberFormatException e) {
            System.out.println("Not good number format!!" + s);
        }
    }

    private void addOldCouple(String s, String s1, Home home) {
        try {
            home.createOldCouple(Double.parseDouble(s), Double.parseDouble(s1));
            homes.add(home);
        } catch (NumberFormatException e) {
            System.out.println("Not good number format!!" + s + "  " + s1);
        }
    }

    private void addYoungSingle(String s, Home home) {
        try {
            home.createYoungSingle(Double.parseDouble(s));
            homes.add(home);
        } catch (NumberFormatException e) {
            System.out.println("Not good number format!!" + s);
        }
    }

    private void addYoungCoupleHome(String s, String s1, Home home) {
        try {
            home.createYoungCouple(Double.parseDouble(s), Double.parseDouble(s1));
            homes.add(home);
        } catch (NumberFormatException e) {
            System.out.println("Not good number format!!: " + s + " " + s1);
        }
    }

    private void bills() {
        List<Home> removableHomes = new ArrayList<>();

        for (Home home : homes) {
            home.billDay();
            if (home.getMoney() < 0) {
                removableHomes.add(home);
                System.out.println("Bye.");
            }
        }

        homes.removeAll(removableHomes);
    }

    private String status() {
        return "The total consumption in SovietVille: " + getConsumption();
    }

    private double getConsumption() {
        double totalConsumption = 0;
        for (Home home : homes) {
            totalConsumption += home.getElectricityCost();
        }
        return totalConsumption;
    }

    private String quit() {
        return "The population is: " + getPopulation();
    }

    private int getPopulation() {
        int population = 0;
        for (Home home : homes) {
            population += home.getPeopleFromHome();
        }
        return population;
    }

    public void payDay() {
        for (Home home : homes) {
            home.payDay();
        }
    }

    public List<Home> getHomes() {
        return List.copyOf(homes);
    }
}