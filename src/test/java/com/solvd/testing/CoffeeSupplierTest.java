package com.solvd.testing;

import com.solvd.coffeeplace.CoffeeSupplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CoffeeSupplierTest {

    private static final Logger log = LogManager.getLogger(CoffeeSupplierTest.class);

    @BeforeSuite
    public void startSupplierSuite() {
        log.info("supplier tests starting");
    }

    @AfterSuite
    public void endSupplierSuite() {
        log.info("supplier tests done");
    }

    @BeforeClass
    public void setupSupplierClass() {
        log.info("supplier class ready");
    }

    @AfterClass
    public void cleanupSupplierClass() {
        log.info("supplier class cleaned");
    }

    @BeforeMethod
    public void beforeSupplierMethod() {
        log.info("supplier test starting");
    }

    @AfterMethod
    public void afterSupplierMethod() {
        log.info("supplier test done");
    }

    @Test
    public void testSupplierCreation() {
        CoffeeSupplier supplier = new CoffeeSupplier("beans", 100, 25.0);
        assertEquals(supplier.getName(), "beans", "name mismatch");
        assertEquals(supplier.getBeansStock(), 100, "stock mismatch");
        assertEquals(supplier.getPricePerKilo(), 25.0, "price mismatch");
        log.info("supplier created");
    }

    @Test
    public void testOrderBeansSuccess() {
        CoffeeSupplier supplier = new CoffeeSupplier("test", 50, 20.0);
        boolean result = supplier.orderBeans(30);
        assertTrue(result, "order should succeed");
        assertEquals(supplier.getBeansStock(), 20, "stock after order");
        log.info("beans ordered successfully");
    }

    @Test
    public void testOrderBeansFail() {
        CoffeeSupplier supplier = new CoffeeSupplier("test", 15, 18.5);

        boolean result = supplier.orderBeans(20);

        assertFalse(result, "order should fail");
        assertEquals(supplier.getBeansStock(), 15, "stock unchanged");
        log.warn("bean order failed");
    }

    @Test
    public void testReceiveShipment() {
        CoffeeSupplier supplier = new CoffeeSupplier("shipment", 40, 22.0);
        supplier.receiveShipment(60);
        assertEquals(supplier.getBeansStock(), 100, "stock after shipment");
        log.info("shipment received");
    }

    @Test
    public void testCalculateCost() {
        CoffeeSupplier supplier = new CoffeeSupplier("cost", 100, 30.0);
        double cost = supplier.calculateCost(5);

        assertEquals(cost, 150.0, "cost mismatch");
        log.info("cost calculated");
    }
}