package com.bridgelabz;

import com.bridgelabz.entity.Ride;
import com.bridgelabz.service.InvoiceGeneratorService;
import com.bridgelabz.entity.InvoiceSummary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CabInvoiceGeneratorTest {

    InvoiceGeneratorService invoiceGeneratorService = null;

    @Before
    public void setup(){
        invoiceGeneratorService = new InvoiceGeneratorService();
    }

    @Test
    public void givenDistanceAndTime_CalculateFare() {
        double distance = 10;
        int time = 5;
        double fare = invoiceGeneratorService.calculateFare(distance,time);
        Assert.assertEquals(105,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_CalculateFareShouldBeEqualOrMoreThanBasePrice() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGeneratorService.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_CalculateFare(){
        ArrayList<Ride> rides = new ArrayList<>();

        rides.add(new Ride(10,5));
        rides.add(new Ride(5,2));
        double totalFare = invoiceGeneratorService.calculateFare(rides);

        Assert.assertEquals(157,totalFare,0.0);
    }

    @Test
    public void enhancedInvoice_return_fare_averageFare_totalRides(){
        ArrayList<Ride> rides = new ArrayList<>();

        rides.add(new Ride(10,5));
        rides.add(new Ride(5,2));
        InvoiceSummary invoiceSummary = invoiceGeneratorService.invoiceSummary(rides);
        double expectedFare = 157;
        int totalRides = 2;
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(expectedFare,totalRides);
        Assert.assertEquals(invoiceSummaryExpected,invoiceSummary);
    }

    @Test
    public void givenUserId_returnInvoiceSummary(){
        String userId= "harsh";
        ArrayList<Ride> rides = new ArrayList<>();

        rides.add(new Ride(10,5));
        rides.add(new Ride(5,2));
        invoiceGeneratorService.addRidesToService(userId,rides);

        InvoiceSummary invoiceSummary = invoiceGeneratorService.invoiceSummaryGivenUserID(userId);
        double expectedFare = 157;
        int totalRides = 2;
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(expectedFare,totalRides);
        Assert.assertEquals(invoiceSummaryExpected,invoiceSummary);

    }

    @Test
    public void premiumRides_normalRides(){
        String userId= "harsh";
        ArrayList<Ride> rides = new ArrayList<>();

        rides.add(new Ride(10,5,"P"));
        rides.add(new Ride(10,5,"N"));
        rides.add(new Ride(5,2,"N"));
        invoiceGeneratorService.addRidesToService(userId,rides);

        InvoiceSummary invoiceSummary = invoiceGeneratorService.invoiceSummaryGivenUserIDAndType(userId);
        double expectedFare = 157+160;
        int totalRides = 3;
        InvoiceSummary invoiceSummaryExpected = new InvoiceSummary(expectedFare,totalRides);
        Assert.assertEquals(invoiceSummaryExpected,invoiceSummary);

    }

}
