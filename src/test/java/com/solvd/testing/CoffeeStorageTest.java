package com.solvd.testing;

import com.solvd.coffeeplace.CoffeeStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CoffeeStorageTest {

    private static final Logger log = LogManager.getLogger(CoffeeStorageTest.class);

    @BeforeSuite
    public void startStorageSuite() {
        log.info("storage tests starting");
    }

    @AfterSuite
    public void endStorageSuite() {
        log.info("storage tests done");
    }

    @BeforeMethod
    public void beforeStorageMethod() {
        log.info("storage test starting");
    }

    @AfterMethod
    public void afterStorageMethod() {
        log.info("storage test done");
    }

    @Test
    public void testEmptyStorage() {
        CoffeeStorage storage = new CoffeeStorage();
        assertEquals(storage.getBeansKg(), 0, "beans mismatch");
        assertEquals(storage.getWaterLiters(), 0, "water mismatch");
        assertEquals(storage.getMilkLiters(), 0, "milk mismatch");
        assertEquals(storage.getCups(), 0, "cups mismatch");
        log.info("empty storage verified");
    }

    @Test
    public void testTakeBeansSuccess() {
        CoffeeStorage storage = new CoffeeStorage();
        storage.addBeans(10);
        boolean result = storage.takeBeans(5);
        assertTrue(result, "take should succeed");
        assertEquals(storage.getBeansKg(), 5, "beans after take");
        log.info("beans taken successfully");
    }

    @Test
    public void testTakeBeansFail() {
        CoffeeStorage storage = new CoffeeStorage();
        storage.addBeans(3);
        boolean result = storage.takeBeans(5);
        assertFalse(result, "take should fail");
        assertEquals(storage.getBeansKg(), 3, "beans unchanged");
        log.warn("beans take failed - insufficient stock");
    }

    @Test
    public void testTakeCup() {
        CoffeeStorage storage = new CoffeeStorage();
        storage.addCups(10);
        boolean first = storage.takeCup();
        boolean second = storage.takeCup();
        assertTrue(first, "first cup failed");
        assertTrue(second, "second cup failed");
        assertEquals(storage.getCups(), 8, "cups after take");
        log.info("cups taken successfully");
    }

    @Test
    public void testAddMultipleSupplies() {
        CoffeeStorage storage = new CoffeeStorage();
        storage.addBeans(5);
        storage.addWater(20);
        storage.addMilk(10);
        storage.addCups(50);
        assertEquals(storage.getBeansKg(), 5, "beans after add");
        assertEquals(storage.getWaterLiters(), 20, "water after add");
        assertEquals(storage.getMilkLiters(), 10, "milk after add");
        assertEquals(storage.getCups(), 50, "cups after add");
        log.info("all supplies added");
    }
}