package edu.wctc.eligrow;

/**
 * Creates Special Event tickets. Implements ITicket
 * @author eplig
 * @version 1.0
 */
public class Special implements ITicket {

    /**
     * Writes the ticket to a readable string
     * @return String: Readable string for file
     */
    @Override
    public String write() {
        return "S," + 20;
    }

    /**
     * Returns 20 as cost of ticket
     * @return Int: Cost of ticket
     */
    @Override
    public int getCost() {
        return 20;
    }

    /**
     * Returns "S" as ticket ID
     * @return String: Ticket ID
     */
    @Override
    public String getID() {
        return "S";
    }
}
