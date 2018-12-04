package edu.wctc.eligrow;

/**
 * Creates Regular tickets and calculates cost based on checkIn/checkOut. Implements ITicket
 * @author eplig
 * @version 1.0
 */
public class Regular implements ITicket {
    private int inTime;
    private int outTime;
    private int cost;

    /**
     * Default constructor for Regular Ticket. Used by TicketFactory
     */
    public Regular () {}

    /**
     * Time-based constructor for Regular Tickets. Calculates cost based on inTime and outTime
     * @param inTime Int: Check-in time for cost calculation
     * @param outTime Int: Check-out time for cost calculation
     */
    public Regular(int inTime, int outTime){
       this.inTime = inTime;
       this.outTime = outTime;
        if((outTime - inTime) < 3){
            cost = 5;
        }else if ((outTime - inTime) < 11){
            cost = ((outTime - inTime)-3) + 5;
        }else{
            cost = 15;
        }
    }


    /**
     * Returns calculated cost of ticket
     * @return Int: Cost of ticket
     */
    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Sets the cost of a Regular ticket. Used while reading files due to variable cost
     * @param cost Int: Value to set cost of Regular.
     */
    public void setCost(int cost){
        this.cost = cost;
    }

    /**
     * Returns "R" as ticket ID
     * @return String: Ticket ID
     */
    @Override
    public String getID() {
        return "R";
    }

    /**
     * Writes the ticket to a readable string
     * @return String: Readable string for file
     */
    @Override
    public String write() {
        return "R," + cost;
    }
}
