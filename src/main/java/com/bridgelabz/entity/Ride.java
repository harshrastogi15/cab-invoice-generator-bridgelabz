package com.bridgelabz.entity;

public class Ride {
    public String typeOfRides;
    public int distance;
    public int time;

    public Ride(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Ride(int distance, int time, String type) {
        this(distance,time);
        this.typeOfRides = type;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "distance=" + distance +
                ", time=" + time +
                '}';
    }
}
