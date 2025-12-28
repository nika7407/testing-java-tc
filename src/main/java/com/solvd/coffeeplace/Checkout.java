package com.solvd.coffeeplace;

public class Checkout<T extends CoffeeMachine> {

    private int orderNumber;
    private double total;
    private int itemCount;

    public Checkout() {
        this.orderNumber = 1;
        this.total = 0.0;
        this.itemCount = 0;
    }

    public void addItem(double price) {
        total += price;
        itemCount++;
    }

    public double processPayment(double amount) {
        if (amount >= total) {
            double change = amount - total;
            reset();
            return change;
        }
        return -1;
    }

    public void cancelOrder() {
        reset();
    }

    private void reset() {
        total = 0.0;
        itemCount = 0;
        orderNumber++;
    }

    public double getTotal() {
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}