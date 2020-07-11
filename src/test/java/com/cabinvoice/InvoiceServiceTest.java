package com.cabinvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception{
        invoiceService = new InvoiceService();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare , 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinumamFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare , 0.0);
    }

    @Test
    public void giveMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.1,1),
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void giveUserIdWithMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.1,1),
        };
        invoiceService.addRide("sai", rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
    }
}
