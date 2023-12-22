package com.bridgelabz.service;

public class InvoiceGeneratorService {
    private static final int TRAVEL_COST_PER_MINUTE = 10;
    private static final int COST_MINUTE = 1;
    private static final double MINIMUM_VALUE_PER_TRAVEL = 5;

    public double calculateFare(double distance, int time) {
        double fare = distance*TRAVEL_COST_PER_MINUTE + time*COST_MINUTE;
        return Math.max(fare,MINIMUM_VALUE_PER_TRAVEL);
    }
}
