package com.solvd.testing.web.firstLink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfo extends AbstractUIObject {

    @FindBy(xpath = ".//aside/div/section/div/div[1]/section/section/div[1]/div[2]/div[2]/div/div[3]/div/p")
    private ExtendedWebElement ItemName;

    @FindBy(xpath = ".//aside/div/section/div/section/div[2]/div[2]/div[3]/div[2]/div/strong")
    private ExtendedWebElement itemsTotal;

    public CheckoutInfo(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItemName() {
        return ItemName;
    }

    public ExtendedWebElement getItemsTotal() {
        return itemsTotal;
    }

    public Double getCheckoutTotal(){
       return Double.parseDouble(getItemsTotal().getText().substring(1));
    }

    public String getSingleItemName(){
        return ItemName.getText().toLowerCase();
    }

}
