package org.bridgelabz;

import com.bridgelabz.service.InvoiceGeneratorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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



}