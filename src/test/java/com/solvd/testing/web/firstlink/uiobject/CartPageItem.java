package com.solvd.testing.web.firstlink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPageItem extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'description')]")
    private ExtendedWebElement itemDescription;

    @FindBy(xpath = ".//*[contains (@class, 'total')]//span")
    private ExtendedWebElement cartTotalCost;

    public CartPageItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItemDescription() {
        return itemDescription;
    }

    public ExtendedWebElement getCartTotalCost() {
        return cartTotalCost;
    }

    public double getCurrentTotal() {
        return Double.parseDouble(getCartTotalCost().getText().substring(1));
    }

    public String getSingleItemInCart() {
        String fullText = getItemDescription().getText();
        return fullText.substring(0, 11).trim().toLowerCase();
    }
}
