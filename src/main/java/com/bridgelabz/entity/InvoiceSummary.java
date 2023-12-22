package com.bridgelabz.entity;

import java.util.Objects;

public class InvoiceSummary {
    public double averageFare;
    public int totalRides;
    public double totalFare;

    public InvoiceSummary(double totalFare, int totalRides) {
        this.totalFare = totalFare;
        this.totalRides = totalRides;
        this.averageFare = this.totalFare/this.totalRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(averageFare, that.averageFare) == 0 && totalRides == that.totalRides && Double.compare(totalFare, that.totalFare) == 0;
    }

}
