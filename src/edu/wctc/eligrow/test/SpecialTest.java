package edu.wctc.eligrow.test;

import edu.wctc.eligrow.Special;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialTest extends TestCase {

    Special special = new Special();

    @Test
    public void testWrite() {
        assertEquals("S,20", special.write());
    }

    @Test
    public void testGetCost() {
        assertEquals(20, special.getCost());
    }

    @Test
    public void testGetID() {
        assertEquals("S", special.getID());
    }
}