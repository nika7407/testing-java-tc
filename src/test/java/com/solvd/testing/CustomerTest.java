package com.solvd.testing;

import com.solvd.coffeeplace.Customer;
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

public class CustomerTest {

    private static final Logger log = LogManager.getLogger(CustomerTest.class);

    @BeforeSuite
    public void startCustomerSuite() {
        log.info("customer tests starting");
    }

    @AfterSuite
    public void endCustomerSuite() {
        log.info("customer tests done");
    }

    @BeforeClass
    public void setupCustomerClass() {
        log.info("customer class ready");
    }

    @AfterClass
    public void cleanupCustomerClass() {
        log.info("customer class cleaned");
    }

    @BeforeMethod
    public void beforeCustomerMethod() {
        log.info("customer test starting");
    }

    @AfterMethod
    public void afterCustomerMethod() {
        log.info("customer test done");
    }

    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer("john", 50.0);
        assertEquals(customer.getName(), "john");
        assertEquals(customer.getWallet(), 50.0);
        assertEquals(customer.getVisits(), 0);
        log.info("customer created");
    }

    @Test
    public void testMakePurchaseSuccess() {
        Customer customer = new Customer("nika", 30.0);
        boolean result = customer.makePurchase(15.0);
        assertTrue(result);
        assertEquals(customer.getWallet(), 15.0);
        assertEquals(customer.getVisits(), 1);
        log.info("purchase successful");
    }

    @Test
    public void testMakePurchaseFail() {
        Customer customer = new Customer("gio", 10.0);
        boolean result = customer.makePurchase(20.0);
        assertFalse(result);
        assertEquals(customer.getWallet(), 10.0);
        assertEquals(customer.getVisits(), 0);
        log.warn("purchase failed");
    }

    @Test
    public void testAddMoney() {
        Customer customer = new Customer("mako", 25.0);
        customer.addMoney(15.0);
        assertEquals(customer.getWallet(), 40.0);
        log.info("money added");
    }

    @Test
    public void testVisitShop() {
        Customer customer = new Customer("diana", 100.0);
        customer.visitShop();
        customer.visitShop();
        customer.visitShop();
        assertEquals(customer.getVisits(), 3);
        log.info("shop visits counted");
    }
}