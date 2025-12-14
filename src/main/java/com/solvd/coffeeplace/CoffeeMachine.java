package com.solvd.coffeeplace;

public class CoffeeMachine {

    public String brand;
    public int waterLevel;
    public int beansLevel;
    public int cupsMade = 0;

    public CoffeeMachine(String brand, int waterLevel, int beansLevel) {
        this.brand = "cofemachine - " + brand;
        this.waterLevel = waterLevel;
        this.beansLevel = beansLevel;
    }

    public void makeCoffee(int waterNedeed, int beansNedeed) {
        if (waterNedeed <= waterLevel && beansNedeed <= beansLevel) {
            waterLevel = waterLevel - waterNedeed;
            beansLevel = beansLevel - beansNedeed;
            cupsMade++;
            System.out.println("cofee" + cupsMade + "made");
        } else {
            System.out.println("not enough beans or cofee");
        }
    }

    public void printStatus() {
        System.out.println("cups made " + cupsMade);
        System.out.println("water level " + waterLevel);
        System.out.println("beans level " + beansLevel);
    }

    public void refillWater(int amount) {
        waterLevel = waterLevel + amount;
    }

    public void refillBeans(int amount) {
        beansLevel = beansLevel + amount;
    }

    public String getBrand() {
        return brand;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getBeansLevel() {
        return beansLevel;
    }

    public int getCupsMade() {
        return cupsMade;
    }
}