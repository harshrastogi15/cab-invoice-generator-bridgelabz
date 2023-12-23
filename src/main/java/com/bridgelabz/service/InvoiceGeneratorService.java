package com.bridgelabz.service;

import com.bridgelabz.entity.InvoiceSummary;
import com.bridgelabz.entity.Ride;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceGeneratorService {
    private static final int TRAVEL_COST_PER_MINUTE = 10;
    private static final int COST_MINUTE = 1;
    private static final double MINIMUM_VALUE_PER_TRAVEL = 5;

    public HashMap<String, ArrayList<Ride>> userDetails;

    public InvoiceGeneratorService() {
        this.userDetails = new HashMap<>();
    }

    public double calculateFare(double distance, int time) {
        double fare = distance*TRAVEL_COST_PER_MINUTE + time*COST_MINUTE;
        return Math.max(fare,MINIMUM_VALUE_PER_TRAVEL);
    }

    public double calculateFare(ArrayList<Ride> rides) {

        double totalFare=0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }

        return totalFare;
    }


    public InvoiceSummary invoiceSummary(ArrayList<Ride> rides) {
        double totalFare = calculateFare(rides);

        return new InvoiceSummary(totalFare,rides.size());
    }

    public void addRidesToService(String userId, ArrayList<Ride> rides) {
        ArrayList<Ride> oldList = (userDetails.containsKey(userId))?userDetails.get(userId):new ArrayList<Ride>();
        oldList.addAll(rides);
        userDetails.put(userId, oldList);
    }

    public InvoiceSummary invoiceSummaryGivenUserID(String userId) {
        ArrayList<Ride> rideList = userDetails.getOrDefault(userId, null);
        if(rideList == null){
            return null;
        }

        return this.invoiceSummary(rideList);
    }
}
