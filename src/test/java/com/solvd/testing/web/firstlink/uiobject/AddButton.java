package com.solvd.testing.web.firstlink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AddButton extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@id,'add')]")
    private ExtendedWebElement addToCartButton;

    public AddButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void pressAddToCartButton() {
        getAddToCartButton().click();
    }
}
