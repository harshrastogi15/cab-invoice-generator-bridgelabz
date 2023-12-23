package com.bridgelabz.entity;

public class Ride {
    public int distance;
    public int time;

    public Ride(int distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "distance=" + distance +
                ", time=" + time +
                '}';
    }
}
