package com.solvd.testing.web.firstlink.uiobject;

import com.solvd.testing.web.firstlink.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Headers extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'toggle-drawer cart desktop ')]")
    private ExtendedWebElement cart;

    @FindBy(xpath = ".//*[contains(@class,'checkout')]")
    private ExtendedWebElement checkout;

    public Headers(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCart() {
        return cart;
    }

    public ExtendedWebElement getCheckout() {
        return checkout;
    }

    public CartPage pressCheckout() {
        getCheckout().hover();
        getCheckout().click();
        return new CartPage(driver);
    }

}
