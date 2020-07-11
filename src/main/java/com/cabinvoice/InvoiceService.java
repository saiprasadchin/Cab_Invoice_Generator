package com.cabinvoice;

public class InvoiceService {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return totalFare;
    }
}
