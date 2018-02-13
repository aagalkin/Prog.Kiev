package com.company;

public class GasTank {
    private int capacity;
    private double fuel = 10;

    public GasTank(){
        capacity = 100;
    }

    //медот заправки машины
    public void addFuel(int fuel){
        this.fuel += fuel;
    }

    public void consumeFuel(double consumption, int speed){
        fuel -= (consumption / 100) * (double)(speed / 60);
    }

    public double getFuel() {
        return fuel;
    }
}
