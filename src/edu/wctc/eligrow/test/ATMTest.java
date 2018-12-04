package edu.wctc.eligrow.test;

import edu.wctc.eligrow.ATM;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class ATMTest extends TestCase {

    @Test
    public void testReadPrevReport() {
        assertNotNull(ATM.ReadPrevReport("tickets.csv"));
    }
}