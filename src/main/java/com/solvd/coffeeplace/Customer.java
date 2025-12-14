package com.solvd.coffeeplace;

public class Customer {
    private String name;
    private double wallet;
    private int visits;

    public Customer(String name, double initialMoney) {
        this.name = name;
        this.wallet = initialMoney;
        this.visits = 0;
    }

    public boolean makePurchase(double amount) {
        if (wallet >= amount) {
            wallet -= amount;
            visits++;
            return true;
        }
        return false;
    }

    public void addMoney(double amount) {
        if (amount > 0) {
            wallet += amount;
        }
    }

    public void visitShop() {
        visits++;
    }

    public String getName() {
        return name;
    }

    public double getWallet() {
        return wallet;
    }

    public int getVisits() {
        return visits;
    }
}