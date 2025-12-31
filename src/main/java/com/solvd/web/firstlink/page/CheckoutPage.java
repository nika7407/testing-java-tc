package com.solvd.web.firstlink.page;

import com.solvd.web.firstlink.uiobject.CheckoutInfo;
import com.solvd.web.firstlink.uiobject.CheckoutPageTotal;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@aria-label, 'Shopping cart']")
    private CheckoutInfo checkoutInfo;

    @FindBy(xpath = "//*[starts-with(@aria-labelledby, 'MoneyLine-Heading')]")
    private CheckoutPageTotal checkoutPageTotal;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutInfo getCheckoutInfo() {
        return checkoutInfo;
    }

    public CheckoutPageTotal getCheckoutPageTotal() {
        return checkoutPageTotal;
    }

}
