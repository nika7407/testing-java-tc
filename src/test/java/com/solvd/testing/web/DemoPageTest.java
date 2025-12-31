package com.solvd.testing.web;

import com.solvd.web.firstlink.page.CartPage;
import com.solvd.web.firstlink.page.CheckoutPage;
import com.solvd.web.firstlink.page.ItemPage;
import com.solvd.web.firstlink.page.MainPage;
import com.zebrunner.carina.core.AbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoPageTest extends AbstractTest {

    private static final Logger log = LogManager.getLogger(DemoPageTest.class);

    @Test(description = "test check adding singular item into cart, veryfying and going to the purchase page")
    public void testAddingSingleObject() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        MainPage homePage = new MainPage(getDriver());
        homePage.open();
        String productName = homePage.getPageObjectToPurchase().getItemToBuyName().toLowerCase();
        Double productCost = homePage.getPageObjectToPurchase().getItemToBuyCost();

        ItemPage itemPage = homePage.getPageObjectToPurchase().clickObjectToPurchace();

        itemPage.getAddButton().pressAddToCartButton();
        Thread.sleep(2000);
        CartPage cartPage = itemPage.getPageHeader().pressCheckout();

        String cartProductName = cartPage.getCartPageItem().getSingleItemInCart();
        Double cartProductCost = cartPage.getCartPageItem().getCurrentTotal();

        softAssert.assertEquals(cartProductName, productName, "Cart name is incorrect");
        softAssert.assertEquals(cartProductCost, productCost, "Cart cost is incorrect");

        CheckoutPage checkoutPage = cartPage.getCheckoutButton().pressCheckoutButton();

        String checkoutItem = checkoutPage.getCheckoutInfo().getSingleItemName().toLowerCase();
        Double checkoutItemsTotal = checkoutPage.getCheckoutPageTotal().getCheckoutTotal();

        softAssert.assertEquals(productName, checkoutItem, "Checkout name is incorrect");
        softAssert.assertEquals(productCost, checkoutItemsTotal, "Checkout total is incorrect");
        softAssert.assertAll();
    }

    @Test(description = "test Adding Multiple Items")
    public void testAddingMultipleObjects() throws InterruptedException {

        int amountToAdd = 5;
        SoftAssert softAssert = new SoftAssert();

        MainPage homePage = new MainPage(getDriver());
        homePage.open();
        String productName = homePage.getPageObjectToPurchase().getItemToBuyName().toLowerCase();
        Double productCost = homePage.getPageObjectToPurchase().getItemToBuyCost();

        ItemPage itemPage = homePage.getPageObjectToPurchase().clickObjectToPurchace();
        for (int i = 0; i < amountToAdd; i++) {
            itemPage.getAddButton().pressAddToCartButton();
            Thread.sleep(2000);
        }
        Double shouldBeCost = productCost * amountToAdd;

        Thread.sleep(2000);
        CartPage cartPage = itemPage.getPageHeader().pressCheckout();

        String cartProductName = cartPage.getCartPageItem().getSingleItemInCart().toLowerCase();
        Double cartProductCost = cartPage.getCartPageItem().getCurrentTotal();

        softAssert.assertEquals(cartProductName, productName, "Cart name is incorrect");
        softAssert.assertEquals(shouldBeCost, cartProductCost, "Cart total is incorrect");

        CheckoutPage checkoutPage = cartPage.getCheckoutButton().pressCheckoutButton();

        String checkoutItem = checkoutPage.getCheckoutInfo().getSingleItemName().toLowerCase();
        Double checkoutItemsTotal = checkoutPage.getCheckoutPageTotal().getCheckoutTotal();

        softAssert.assertEquals(productName, checkoutItem, "Checkout name is incorrect");
        softAssert.assertEquals(shouldBeCost, checkoutItemsTotal, "Checkout total is incorrect");
        softAssert.assertAll();
    }

    @Test(description = "test left sidebar links navigation")
    public void testSidebarLinks() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();

        mainPage.getSidebarLinks().clickAboutUsLink();
        softAssert.assertEquals(getDriver().getCurrentUrl().contains("about-us"), true, "About page is not opened");
        getDriver().navigate().back();

        mainPage.getSidebarLinks().clickCatalogLink();
        softAssert.assertEquals(getDriver().getCurrentUrl().contains("/collections/all"), true, "Catalog page is not opened");
        getDriver().navigate().back();

        mainPage.getSidebarLinks().clickBlogLink();
        softAssert.assertEquals(getDriver().getCurrentUrl().contains("blogs"), true, "Blog page is not opened");
        softAssert.assertAll();
    }
}
