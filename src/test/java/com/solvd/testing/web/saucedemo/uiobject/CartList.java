package com.solvd.testing.web.saucedemo.uiobject;

import com.solvd.testing.web.saucedemo.page.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartList extends AbstractUIObject {

    @FindBy(xpath = ".//div[3]")
    private ExtendedWebElement cartItem1;

    @FindBy(xpath = ".//div[4]")
    private ExtendedWebElement cartItem2;

    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkoutButton;


    public CartList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCartItem1() {
        return cartItem1;
    }

    public ExtendedWebElement getCartItem2() {
        return cartItem2;
    }

    public String getItem1Name() {
        return getCartItem1().findElement(By.className("inventory_item_name")).getText().toLowerCase();
    }

    public String getItem2Name() {
        return getCartItem2().findElement(By.className("inventory_item_name")).getText().toLowerCase();
    }

    public Double getItem1Cost() {
        return Double.valueOf(getCartItem1().findElement(By.className("inventory_item_price")).getText().substring(1));
    }

    public Double getItem2Cost() {
        return Double.valueOf(getCartItem2().findElement(By.className("inventory_item_price")).getText().substring(1));
    }
    public CheckoutPage pressCheckout(){
        checkoutButton.hover();
        checkoutButton.click();
        return new CheckoutPage(getDriver());
    }



}
