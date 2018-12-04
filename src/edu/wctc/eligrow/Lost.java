package edu.wctc.eligrow;

/**
 * Creates Lost tickets. Implements ITicket
 * @author eplig
 * @version 1.0
 */
public class Lost implements ITicket {

    /**
     * Writes the ticket to a readable string
     * @return String: Readable string for file
     */
    @Override
    public String write() {
        return "L," + 25;
    }

    /**
     * Returns 25 as cost of ticket
     * @return Int: Cost of ticket
     */
    @Override
    public int getCost() {
        return 25;
    }

    /**
     * Returns "L" as ticket ID
     * @return String: Ticket ID
     */
    @Override
    public String getID() {
        return "L";
    }
}
