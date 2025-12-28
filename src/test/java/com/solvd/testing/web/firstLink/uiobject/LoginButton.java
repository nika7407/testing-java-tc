package com.solvd.testing.web.firstLink.uiobject;

import com.solvd.testing.web.firstLink.page.LoginPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginButton extends AbstractUIObject {

    @FindBy(xpath = ".//nav/a[3]")
    private ExtendedWebElement LoginButton;

    public LoginButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLoginButton() {
        return LoginButton;
    }

    public LoginPage pressLogin(){
        getLoginButton().hover();
        getLoginButton().click();
        return new LoginPage(driver);
    }
}
