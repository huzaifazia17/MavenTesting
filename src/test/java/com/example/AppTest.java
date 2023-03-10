package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void nextDayTest() {
        assertEquals(App.NextDate(3, 9, 1812), "4 9 1812");
        assertEquals(App.NextDate(5, 4, 2212), "6 4 2212");
        assertEquals(App.NextDate(11, 11, 1950), "12 11 1950");
        assertEquals(App.NextDate(7, 5, 1970), "8 5 1970");
        assertEquals(App.NextDate(22, 8, 1845), "23 8 1845");
        assertEquals(App.NextDate(30, 12, 1897), "31 12 1897");
    }

    @Test
    public void nextYearTest() {
        assertEquals(App.NextDate(31, 12, 2000), "1 1 2001");
        assertEquals(App.NextDate(31, 12, 1990), "1 1 1991");
        assertEquals(App.NextDate(31, 12, 1900), "1 1 1901");
        assertEquals(App.NextDate(31, 12, 1899), "1 1 1900");
        assertEquals(App.NextDate(31, 12, 2100), "1 1 2101");
        assertEquals(App.NextDate(31, 12, 2200), "1 1 2201");
    }

    @Test
    public void incorrectDay() {
        assertEquals(App.NextDate(99, 12, 1900), "Error: Date is incorrect ");
        assertEquals(App.NextDate(11, 23, 2002), "Error: Date is incorrect ");
        assertEquals(App.NextDate(1, 1, 1500), "Error: Dates can only be between 1812 and 2212");
        assertEquals(App.NextDate(234, 234, 234), "Error: Dates can only be between 1812 and 2212");
        assertEquals(App.NextDate(5, 34, 34), "Error: Dates can only be between 1812 and 2212");
        assertEquals(App.NextDate(67, 67, 2089), "Error: Date is incorrect ");
    }

    @Test
    public void leapYearTest() {
        assertEquals(App.NextDate(28, 2, 1892), "29 2 1892");
        assertEquals(App.NextDate(28, 2, 1872), "29 2 1872");
        assertEquals(App.NextDate(28, 2, 2104), "29 2 2104");
        assertEquals(App.NextDate(29, 2, 2092), "1 3 2092");
        assertEquals(App.NextDate(29, 2, 1828), "1 3 1828");
        assertEquals(App.NextDate(29, 2, 2180), "1 3 2180");
    }

    @Test
    public void nonLeapYearTest() {
        assertEquals(App.NextDate(28, 2, 1815), "1 3 1815");
        assertEquals(App.NextDate(28, 2, 2086), "1 3 2086");
        assertEquals(App.NextDate(28, 2, 1922), "1 3 1922");
        assertEquals(App.NextDate(29, 2, 1815), "Error: Date is incorrect ");
        assertEquals(App.NextDate(29, 2, 2086), "Error: Date is incorrect ");
        assertEquals(App.NextDate(29, 2, 1922), "Error: Date is incorrect ");
    }

}
