package com.solvd.testing.web.firstlink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfo extends AbstractUIObject {

    @FindBy(xpath = "(.//p)[1]")
    private ExtendedWebElement ItemName;

    public CheckoutInfo(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItemName() {
        return ItemName;
    }

    public String getSingleItemName() {
        return ItemName.getText().toLowerCase();
    }

}
