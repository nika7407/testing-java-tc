package com.solvd.testing.web.firstLink.uiobject;

import com.solvd.testing.web.firstLink.page.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutButton extends AbstractUIObject {

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;

    public CheckoutButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }

     public CheckoutPage pressCheckoutButton(){
        checkoutButton.hover();
        checkoutButton.click();
        return new CheckoutPage(driver);
     }

}
