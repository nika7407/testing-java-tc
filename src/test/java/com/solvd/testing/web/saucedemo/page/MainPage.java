package com.solvd.testing.web.saucedemo.page;

import com.solvd.testing.web.saucedemo.uiobject.InventoryList;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(className = "inventory_list")
    private InventoryList inventoryList;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public InventoryList getInventoryList() {
        return inventoryList;
    }
}
