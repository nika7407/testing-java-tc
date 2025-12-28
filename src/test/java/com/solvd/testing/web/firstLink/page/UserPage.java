package com.solvd.testing.web.firstLink.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserPage extends AbstractPage {

    @FindBy(xpath = ".//span[contains (@class, 'customer-name')]")
    private ExtendedWebElement userName;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getUserName() {
        return userName;
    }
}
