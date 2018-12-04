package edu.wctc.eligrow;

/**
 * Responsible for creating different types of tickets based on input
 * @author eplig
 * @version 1.0
 */
public class TicketFactory {

    /**
     * Creates ITicket objects based on input
     * @param ticketType String: Ticket ID drawn from report
     * @return ITicket: ITicket object to add to array
     */
    public ITicket getTicket(String ticketType){
        switch (ticketType){
            case "R":
                return new Regular();
            case "L":
                return new Lost();
            case "S":
                return new Special();
            default:
                return null;
        }
    }
}
