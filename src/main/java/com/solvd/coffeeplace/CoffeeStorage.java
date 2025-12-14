package com.solvd.coffeeplace;

public class CoffeeStorage {
    private int beansKg;
    private int waterLiters;
    private int milkLiters;
    private int cups;

    public CoffeeStorage() {
        this.beansKg = 0;
        this.waterLiters = 0;
        this.milkLiters = 0;
        this.cups = 0;
    }

    public boolean takeBeans(int kg) {
        if (beansKg >= kg) {
            beansKg -= kg;
            return true;
        }
        return false;
    }

    public boolean takeWater(int liters) {
        if (waterLiters >= liters) {
            waterLiters -= liters;
            return true;
        }
        return false;
    }

    public boolean takeMilk(int liters) {
        if (milkLiters >= liters) {
            milkLiters -= liters;
            return true;
        }
        return false;
    }

    public boolean takeCup() {
        if (cups > 0) {
            cups--;
            return true;
        }
        return false;
    }

    public void addBeans(int kg) {
        beansKg += kg;
    }

    public void addWater(int liters) {
        waterLiters += liters;
    }

    public void addMilk(int liters) {
        milkLiters += liters;
    }

    public void addCups(int count) {
        cups += count;
    }

    public int getBeansKg() {
        return beansKg;
    }

    public int getWaterLiters() {
        return waterLiters;
    }

    public int getMilkLiters() {
        return milkLiters;
    }

    public int getCups() {
        return cups;
    }
}