package com.solvd.testing.web.firstLink.page;

import com.solvd.testing.web.firstLink.uiobject.CheckoutInfo;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = "//div[contains (@class, '_4QenE')]")
    private CheckoutInfo checkoutInfo;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInfo getCheckoutInfo() {
        return checkoutInfo;
    }
}
