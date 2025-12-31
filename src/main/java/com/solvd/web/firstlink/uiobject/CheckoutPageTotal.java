package com.solvd.web.firstlink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPageTotal extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@role, 'cell']//strong")
    private ExtendedWebElement total;

    public CheckoutPageTotal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTotal() {
        return total;
    }

    public Double getCheckoutTotal() {
        return Double.parseDouble(getTotal().getText().substring(1));
    }

}

