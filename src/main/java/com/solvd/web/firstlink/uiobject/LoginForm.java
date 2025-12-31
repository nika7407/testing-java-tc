package com.solvd.web.firstlink.uiobject;

import com.solvd.web.firstlink.page.UserPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains (@id, 'customer_email')]")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = ".//*[contains (@id, 'customer_password')]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = ".//*[contains (@class, 'button')]")
    private ExtendedWebElement LoginButton;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmailInput() {
        return emailInput;
    }

    public ExtendedWebElement getPasswordInput() {
        return passwordInput;
    }

    public void inputEmail(String email) {
        getEmailInput().hover();
        getEmailInput().click();
        getEmailInput().type(email);
    }

    public void inputPassword(String password) {
        getPasswordInput().hover();
        getPasswordInput().click();
        getPasswordInput().type(password);
    }

    public ExtendedWebElement getLoginButton() {
        return LoginButton;
    }

    public UserPage pressLogin() {
        getLoginButton().hover();
        getLoginButton().click();
        return new UserPage(driver);
    }


}
