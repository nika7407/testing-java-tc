package com.solvd.web.firstlink.page;

import com.solvd.web.firstlink.uiobject.LoginForm;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "customer_login")
    private LoginForm loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }
}
