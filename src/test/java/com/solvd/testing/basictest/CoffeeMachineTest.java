package com.solvd.testing.basictest;

import com.solvd.coffeeplace.CoffeeMachine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CoffeeMachineTest {
    private CoffeeMachine machine;

    @BeforeMethod
    public void setup() {
        machine = new CoffeeMachine("JustCoffee", 1000, 500);
    }

    @Test
    public void testMakesCoffee() {
        machine.makeCoffee(200, 50);
        assertEquals(machine.getCupsMade(), 1, "cups mismatch");
        assertEquals(machine.getWaterLevel(), 800, "water after coffee");
        assertEquals(machine.getBeansLevel(), 450, "beans after coffee");
    }

    @Test
    public void testFailsWhenLow() {
        machine = new CoffeeMachine("name", 1000, 10);
        machine.makeCoffee(200, 100);
        assertEquals(machine.getCupsMade(), 0, "cups should be zero");
        assertEquals(machine.getWaterLevel(), 1000, "water unchanged");
    }

    @Test
    public void testMultipleCoffees() {
        machine.makeCoffee(200, 50);
        machine.makeCoffee(200, 50);
        machine.makeCoffee(200, 50);

        assertEquals(machine.getCupsMade(), 3, "total cups mismatch");
        assertEquals(machine.getWaterLevel(), 400, "water after three");
        assertEquals(machine.getBeansLevel(), 350, "beans after three");
    }

    @Test
    public void tetsRefill() {
        machine.makeCoffee(800, 400);
        machine.refillWater(500);
        machine.refillBeans(300);

        assertEquals(machine.getWaterLevel(), 700, "water after refill");
        assertEquals(machine.getBeansLevel(), 400, "beans after refill");
    }

    @Test
    public void testZeroCoffeeBug() {
        machine.makeCoffee(0, 0);

        assertEquals(machine.getCupsMade(), 1, "cups should be one");
        assertEquals(machine.getWaterLevel(), 1000, "water unchanged");
        assertEquals(machine.getBeansLevel(), 500, "beans unchanged");
    }

    @Test
    public void testBrandFormat() {
        assertEquals(machine.getBrand(), "cofemachine - JustCoffee", "brand format wrong");
        CoffeeMachine other = new CoffeeMachine("italy", 500, 300);
        assertEquals(other.getBrand(), "cofemachine - italy", "brand format mismatch");
    }

}