package edu.wctc.eligrow.test;

import edu.wctc.eligrow.Lost;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class LostTest extends TestCase {

    Lost lost = new Lost();

    @Test
    public void testWrite() {
        assertEquals("L,25", lost.write());
    }

    @Test
    public void testGetCost() {
        assertEquals(25, lost.getCost());
    }

    @Test
    public void testGetID() {
        assertEquals("L", lost.getID());
    }
}