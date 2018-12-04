package edu.wctc.eligrow;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * @author eplig
 * @version 1.0
 */
public class ATM {

    private static ATM atm = new ATM();

    private ATM() {}

    public static ATM SingleInstance(){
        return atm;
    }

    /**
     * Reads CSV file and converts it to ArrayList. Returns said ArrayList.
     * @param fileName String: Name of file
     * @return ArrayList<Ticket>: ArrayList of Ticket objects to be used later in the program.
     */
    public static ArrayList<ITicket> ReadPrevReport(String fileName) {
        ArrayList<ITicket> totalTickets = new ArrayList<>();
        FileInput prevReport;
        String line;
        TicketFactory ticketFactory = new TicketFactory();
        try {
            prevReport = new FileInput(fileName);
            while ((line = prevReport.fileReadLine()) != null) {
                String[] toBeConverted = line.split(",");

                    String typeID = toBeConverted[0];
                    int cost = Integer.parseInt(toBeConverted[1]);
                    ITicket ticket = ticketFactory.getTicket(typeID);
                if (ticket instanceof Regular) {
                    ((Regular) ticket).setCost(cost);
                }
                totalTickets.add(ticket);
            }
            prevReport.fileClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalTickets;
    }

    /**
     * Adds to file and ArrayList based on user action
     * @param al ArrayList<Ticket>: ArrayList to add to for program.
     * @param fileName String: Name of file
     */
    public static void CheckIn(ArrayList<ITicket> al, String fileName) {
        Scanner keyboard = new Scanner(System.in);
        Random checkIn = new Random();
        Random checkOut = new Random();
        boolean goodInput = false;
        int subAns;
        try {

            do {
                FileOutput out = new FileOutput(fileName);
                int inTime = checkIn.nextInt((12 - 7) + 1) + 7;
                System.out.print(" Best Value Parking Garage\n =========================\n 1) Check out\n " +
                        "2) Lost Ticket\n=>");
                subAns = keyboard.nextInt();
                if (subAns == 1) {
                    int outTime = checkOut.nextInt((23 - 13) + 1) + 13;
                    ITicket newTicket = new Regular(inTime, outTime);
                    if (inTime < 12) {
                        System.out.println(" Best Value Parking Garage\n =========================\n Receipt for vehicle id " +
                                (al.size() + 1) + "\n " + (outTime - inTime) + " hours parked  " + inTime + " am - " +
                                (outTime - 12) + " pm\n $" + newTicket.getCost());
                    } else {
                        System.out.println(" Best Value Parking Garage\n =========================\n Receipt for vehicle id" +
                                (al.size() + 1) + "\n " + (outTime - inTime) + " hours parked " + inTime + " pm - " +
                                (outTime - 12) + " pm\n $" + newTicket.getCost());
                    }
                    al.add(newTicket);
                    String str = newTicket.write();
                    out.fileWrite(str);
                    System.out.print("Press enter to continue:");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    out.fileClose();
                    goodInput = true;
                } else if (subAns == 2) {
                    ITicket newTicket = new Lost();
                    System.out.println(" Best Value Parking Garage\n =========================\n Receipt for vehicle id " +
                            (al.size() + 1) + "\n Lost Ticket" + "\n $" + newTicket.getCost());
                    al.add(newTicket);
                    String str = newTicket.write();
                    out.fileWrite(str);
                    System.out.print("Press enter to continue:");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    out.fileClose();
                    goodInput = true;
                } else {
                    System.out.println("This is an invalid input. Please enter a valid input.");
                }
            } while (!goodInput);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Adds to file and ArrayList based on user action of selecting Special Event
     * @param al ArrayList<Ticket>: ArrayList to add to for program.
     * @param fileName String: Name of file
     */
    public static void Special(ArrayList<ITicket> al, String fileName){
        Scanner keyboard = new Scanner(System.in);
        try {
            FileOutput out = new FileOutput(fileName);
            ITicket newTicket = new Special();
            al.add(newTicket);
            out.fileWrite(newTicket.write());

            System.out.println(" Best Value Parking Garage\n =========================\n Receipt for vehicle id" +
                    (al.size() + 1) + "\n " + " Special Event \n $" + newTicket.getCost());
            System.out.print("Press enter to continue:");

            keyboard.nextLine();
            out.fileClose();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Summarizes ArrayList into a report.
     * @param al ArrayList<Ticket>: ArrayList to read from.
     */
    public static void CloseGarage(ArrayList<ITicket> al){
        int grandTotal = 0;
        int lCost = 0;
        int rCost = 0;
        int rTickets = 0;
        int lTickets = 0;
        int sTickets = 0;
        int sCost = 0;

        for (ITicket tally : al) {

            if (tally.getID() == "L") {
                lTickets++;
                lCost += 25;
            } else if (tally.getID() == "R") {
                rCost += tally.getCost();
                rTickets++;
            }else if (tally.getID() == "S"){
                sTickets++;
                sCost += 20;
            }
            grandTotal += tally.getCost();
        }

        System.out.print(" Best Value Parking Garage\n =========================\n Activity to date\n\n $" +
                rCost + " was collected from " + rTickets + " check-ins\n $" + lCost +
                " was collected from " + lTickets + " lost tickets\n $" + sCost + " was collected from " + sTickets
                + " Special Events\n\n $" + grandTotal + " was collected overall.\n\n Press enter to close the garage.");
    }
}

