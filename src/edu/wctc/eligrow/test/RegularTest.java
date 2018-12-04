package edu.wctc.eligrow.test;

import edu.wctc.eligrow.Regular;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularTest extends TestCase {

    Regular regular = new Regular();

    @Before
    public void setUp()
    {
        regular.setCost(15);
    }

    @Test
    public void testGetCost() {
        assertEquals(15, regular.getCost());
    }

    @Test
    public void testGetID() {
        assertEquals("R", regular.getID());
    }

    @Test
    public void testWrite() {
        assertEquals("R,15", regular.write());
    }
}