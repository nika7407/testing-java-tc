package com.solvd.testing.web.firstlink.page;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserPage extends AbstractPage {

    @FindBy(xpath = ".//*[contains (@class, 'customer-name')]")
    private ExtendedWebElement userName;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getUserName() {
        return userName;
    }
}
