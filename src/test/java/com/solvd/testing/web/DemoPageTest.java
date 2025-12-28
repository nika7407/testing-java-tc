package com.solvd.testing.web;

import com.solvd.testing.web.firstLink.page.CartPage;
import com.solvd.testing.web.firstLink.page.CheckoutPage;
import com.solvd.testing.web.firstLink.page.ItemPage;
import com.solvd.testing.web.firstLink.page.MainPage;
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

        String cartProductName = cartPage.getCartPageItem().getSingleItemInCart().toLowerCase();
        Double cartProductCost = cartPage.getCartPageItem().getCurrentTotal();


        softAssert.assertEquals(cartProductName, productName);
        softAssert.assertEquals(cartProductCost, productCost);

        CheckoutPage checkoutPage = cartPage.getCheckoutButton().pressCheckoutButton();

        String checkoutItem = checkoutPage.getCheckoutInfo().getSingleItemName().toLowerCase();
        Double checkoutItemsTotal = checkoutPage.getCheckoutInfo().getCheckoutTotal();

        softAssert.assertEquals(productName, checkoutItem);
        softAssert.assertEquals(productCost, checkoutItemsTotal);
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


        softAssert.assertEquals(cartProductName, productName);
        softAssert.assertEquals(shouldBeCost, cartProductCost);
        CheckoutPage checkoutPage = cartPage.getCheckoutButton().pressCheckoutButton();

        String checkoutItem = checkoutPage.getCheckoutInfo().getSingleItemName().toLowerCase();
        Double checkoutItemsTotal = checkoutPage.getCheckoutInfo().getCheckoutTotal();


        softAssert.assertEquals(productName, checkoutItem);
        softAssert.assertEquals(shouldBeCost, checkoutItemsTotal);
        softAssert.assertAll();
    }

//    @Test(description = "test login with correct credential")
//    public void testLogin() throws InterruptedException {
//        MainPage mainPage = new MainPage(getDriver());
//        mainPage.open();
//        Thread.sleep(3060);
//        SoftAssert softAssert = new SoftAssert();
//        Thread.sleep(3060);
//        LoginPage loginPage = mainPage.getLoginButton().pressLogin();
//        Thread.sleep(3060);
//        loginPage.getLoginForm().inputEmail(R.TESTDATA.get("test_user_email"));
//        Thread.sleep(3080);
//        loginPage.getLoginForm().inputPassword(R.TESTDATA.get("test_user_password"));
//        Thread.sleep(3040);
//        UserPage userPage = loginPage.getLoginForm().pressLogin();
//        Thread.sleep(3060);
//        softAssert.assertEquals(userPage.isPageOpened(), true);
//        softAssert.assertEquals(userPage.getUserName().getText() != null, true);
//    }

    @Test(description = "test left sidebar links navigation")
    public void testSidebarLinks() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        MainPage mainPage = new MainPage(getDriver());
        mainPage.open();


        mainPage.getSidebarLinks().clickAboutUsLink();
        softAssert.assertEquals(getDriver().getCurrentUrl().contains("about-us"), true);
        getDriver().navigate().back();


        mainPage.getSidebarLinks().clickCatalogLink();
        softAssert.assertEquals(getDriver().getCurrentUrl().contains("/collections/all"), true);
        getDriver().navigate().back();

        mainPage.getSidebarLinks().clickBlogLink();
        softAssert.assertEquals(getDriver().getCurrentUrl().contains("blogs"), true);
        softAssert.assertAll();
    }


}
