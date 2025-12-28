package com.solvd.testing.web.firstLink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPageItem extends AbstractUIObject {

    @FindBy(xpath = ".//div[1]/div/h3/a")
    private ExtendedWebElement itemDescription;

    @FindBy(xpath = ".//div[4]/span")
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

    public double getCurrentTotal(){
       return Double.parseDouble(getCartTotalCost().getText().substring(1));
    }

    public String getSingleItemInCart(){
        String fullText = getItemDescription().getText();
        return fullText.replaceFirst("\\s*-\\s*.*$", "").trim();
    }
}
