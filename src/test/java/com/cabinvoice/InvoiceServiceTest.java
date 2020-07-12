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
        double fare = invoiceService.calculateFare(RideType.NORMAL, distance, time);
        Assert.assertEquals(25, fare , 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinumamFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(RideType.NORMAL, distance, time);
        Assert.assertEquals(5, fare , 0.0);
    }

    @Test
    public void giveMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(RideType.NORMAL,2.0,5),
                new Ride(RideType.NORMAL,0.1,1),
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void giveUserIdWithMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(RideType.NORMAL,2.0,5),
                new Ride(RideType.NORMAL,0.1,1),
        };
        invoiceService.addRide("sai", rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary("sai");
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenNormalUserId_GenerateTotalFare_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(RideType.NORMAL, 35.0, 45)
                , new Ride(RideType.NORMAL, 10.55, 30), new Ride(RideType.NORMAL, 20, 30)};
        invoiceService.addRide("sai", rides);
        InvoiceSummary invoiceSummery = invoiceService.getInvoiceSummary("sai");
        InvoiceSummary expectedSummery = new InvoiceSummary(3, 760.5);
        Assert.assertEquals(expectedSummery, invoiceSummery);
    }
}
