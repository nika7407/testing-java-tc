package com.solvd.coffeeplace;

public class CoffeeSupplier {

    private String name;
    private int beansStock;
    private double pricePerKilo;

    public CoffeeSupplier(String name, int initialStock, double price) {
        this.name = name;
        this.beansStock = initialStock;
        this.pricePerKilo = price;
    }

    public boolean orderBeans(int kilos) {
        if (beansStock >= kilos) {
            beansStock -= kilos;
            return true;
        }
        return false;
    }

    public void receiveShipment(int kilos) {
        beansStock += kilos;
    }

    public double calculateCost(int kilos) {
        return kilos * pricePerKilo;
    }

    public int getBeansStock() {
        return beansStock;
    }

    public String getName() {
        return name;
    }

    public double getPricePerKilo() {
        return pricePerKilo;
    }
}