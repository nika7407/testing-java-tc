package com.solvd.testing;

import com.solvd.coffeeplace.Checkout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest {

    private static final Logger log = LogManager.getLogger(CheckoutTest.class);

    @BeforeSuite
    public void startCheckoutSuite() {
        log.info("checkout tests starting");
    }

    @AfterSuite
    public void endCheckoutSuite() {
        log.info("checkout tests done");
    }

    @BeforeTest
    public void beforeCheckoutTests() {
        log.info("checkout test block");
    }

    @AfterTest
    public void afterCheckoutTests() {
        log.info("end checkout tests");
    }

    @BeforeMethod
    public void resetForTest() {
        log.info("new checkout test");
    }

    @AfterMethod
    public void testComplete() {
        log.info("checkout test done");
    }

    @Test
    public void testEmptyCheckout() {
        Checkout checkout = new Checkout();
        log.debug("checking empty checkout");
        assertEquals(checkout.getTotal(), 0.0);
        assertEquals(checkout.getItemCount(), 0);
        log.info("empty checkout verified");
    }

    @Test
    public void testAddOneItem() {
        Checkout checkout = new Checkout();
        log.debug("adding single item");

        checkout.addItem(3.50);
        assertEquals(checkout.getTotal(), 3.50);
        assertEquals(checkout.getItemCount(), 1);
        log.info("single item added");
    }

    @Test
    public void testCancelOrder() {
        Checkout checkout = new Checkout();
        checkout.addItem(3.00);
        checkout.addItem(2.00);
        log.debug("cancelling order");

        checkout.cancelOrder();
        assertEquals(checkout.getTotal(), 0.0);
        assertEquals(checkout.getItemCount(), 0);
        log.info("order cancelled");
    }

    @Test
    public void testOrderNumberIncrement() {
        Checkout checkout = new Checkout();
        int firstOrder = checkout.getOrderNumber();
        log.debug("testing order number increment");

        checkout.addItem(1.50);
        checkout.processPayment(2.00);
        int secondOrder = checkout.getOrderNumber();
        assertEquals(secondOrder, firstOrder + 1);
        log.info("order number incremented");
    }

    @Test
    public void testTransactions() {
        Checkout checkout = new Checkout();
        log.debug("testing transactions");
        checkout.addItem(3.00);
        checkout.processPayment(5.00);
        checkout.addItem(4.50);
        checkout.addItem(2.50);
        checkout.processPayment(10.00);
        assertEquals(checkout.getOrderNumber(), 3);
        log.info("transactions completed");
    }

}