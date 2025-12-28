package com.solvd.testing.web;

import com.solvd.testing.web.saucedemo.page.CartPage;
import com.solvd.testing.web.saucedemo.page.CheckoutPage;
import com.solvd.testing.web.saucedemo.page.LoginPage;
import com.solvd.testing.web.saucedemo.page.MainPage;
import com.solvd.testing.web.saucedemo.uiobject.CartList;
import com.solvd.testing.web.saucedemo.uiobject.CheckoutForm;
import com.solvd.testing.web.saucedemo.uiobject.InventoryList;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class SecondDemoPageTest extends AbstractTest {

    @Test(description = "test authentication with valid credentials")
    public void testValidLogin() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getDriver();
        String url = R.CONFIG.get("saucedemo_url");

        LoginPage loginPage = new LoginPage(driver);
        driver.get(url);
        MainPage mainPage = loginPage.login();

        softAssert.assertEquals(mainPage.isPageOpened(), true);
        softAssert.assertAll();
    }

    @Test(description = "test full purchase of multiple items")
    public void testPurchaseOfMultipleItems() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = getDriver();
        String url = R.CONFIG.get("saucedemo_url");

        LoginPage loginPage = new LoginPage(driver);
        driver.get(url);
        MainPage mainPage = loginPage.login();
        softAssert.assertEquals(mainPage.isPageOpened(), true, "failed at mainPage ");

        List<String> itemToBuy = new ArrayList<>();
        Double totalCost = 0.0;
        InventoryList inventoryList = mainPage.getInventoryList();
        Thread.sleep(2000);
        inventoryList.addItem1();
        itemToBuy.add(inventoryList.getItem1Name());
        Thread.sleep(500);
        inventoryList.addItem2();
        itemToBuy.add(inventoryList.getItem2Name());

        totalCost = inventoryList.getItem1Cost() + inventoryList.getItem2Cost();
        CartPage cartPage = inventoryList.pressCart();
        CartList cartList = cartPage.getCartList();

        String cartName1 = cartList.getItem1Name();
        String cartName2 = cartList.getItem2Name();
        Double cartCost1 = cartList.getItem1Cost();
        Double cartCost2 = cartList.getItem2Cost();

        softAssert.assertTrue(itemToBuy.contains(cartName1));
        softAssert.assertTrue(itemToBuy.contains(cartName2));
        Double cartSum = cartCost1 + cartCost2;
        softAssert.assertEquals(totalCost, cartSum);

        CheckoutPage checkoutPage = cartList.pressCheckout();
        CheckoutForm checkoutForm = checkoutPage.checkoutForm;

        checkoutForm.writeName(R.TESTDATA.get("saucedemo_name"));
        checkoutForm.writeLastName(R.TESTDATA.get("saucedemo_last_name"));
        checkoutForm.writePostalCode(R.TESTDATA.get("saucedemo_zip"));

        checkoutForm.pressCheckoutButton();
        driver.findElement(By.id("finish")).click();
        String currentUrl = driver.getCurrentUrl();

        softAssert.assertTrue(currentUrl.equals("https://www.saucedemo.com/checkout-complete.html"), "failed at finishing url");

        softAssert.assertAll();
    }


}
