package edu.wctc.eligrow;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<ITicket> totalTickets;
        Scanner keyboard = new Scanner(System.in);
        int ans = 0;
        boolean closed = false;
        String fileName = "tickets.csv";

        totalTickets = ATM.ReadPrevReport(fileName);
        do {

            System.out.print(" Best Value Parking Garage\n =========================\n 1) Check in\n " +
                    "2) Special Event\n3) Close Garage\n=>");
            ans = keyboard.nextInt();

            if (ans == 1) {
                ATM.CheckIn(totalTickets, fileName);
            }
            else if (ans == 2){
                ATM.Special(totalTickets, fileName);
            }
            else if (ans == 3) {
                ATM.CloseGarage(totalTickets);
                keyboard.nextLine();
                keyboard.nextLine();
                closed = true;
            }else {
                System.out.println("You provided an invalid input. Please enter a valid input.");
            }
        }while(!closed);

    }
}
