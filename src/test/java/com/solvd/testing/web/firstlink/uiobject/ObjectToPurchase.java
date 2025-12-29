package com.solvd.testing.web.firstlink.uiobject;

import com.solvd.testing.web.firstlink.page.ItemPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ObjectToPurchase extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@id,'product-1')]")
    private ExtendedWebElement itemToBuy;

    public ObjectToPurchase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getItemToBuy() {
        return itemToBuy;
    }

    public String getItemToBuyName() {
        return getItemToBuy().findElement(By.xpath(".//h3")).getText();
    }

    public Double getItemToBuyCost() {
        return Double.valueOf(getItemToBuy().findElement(By.xpath(".//h4")).getText().substring(1));
    }

    public ItemPage clickObjectToPurchace() {
        getItemToBuy().click();
        return new ItemPage(driver);
    }
}
