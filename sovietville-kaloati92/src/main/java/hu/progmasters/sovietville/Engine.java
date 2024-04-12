package hu.progmasters.sovietville;

import java.util.Scanner;

public class Engine {
    public static void main(String[] args) {

        Sovietville budapest = new Sovietville();
        Scanner sc = new Scanner(System.in);

        String input = "";
        int roundCounter = 0;

        while (!input.equals("quit")) {
            roundCounter ++;
            input = sc.nextLine();
            budapest.villeRunner(input);

            if (roundCounter % 4 == 0){
                budapest.payDay();
            }
        }
    }
}
