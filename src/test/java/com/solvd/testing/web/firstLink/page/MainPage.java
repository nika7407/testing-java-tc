package com.solvd.testing.web.firstLink.page;

import com.solvd.testing.web.firstLink.uiobject.Headers;
import com.solvd.testing.web.firstLink.uiobject.LoginButton;
import com.solvd.testing.web.firstLink.uiobject.ObjectToPurchase;
import com.solvd.testing.web.firstLink.uiobject.SidebarLinks;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(id = "minicart")
    private Headers pageHeader;

    @FindBy(id = "sidebar")
    private SidebarLinks sidebarLinks;

    @FindBy(id = "page-content")
    private ObjectToPurchase pageObjectToPurchase;

    @FindBy(xpath = "//div[@class='seven columns offset-by-one desktop']")
    private LoginButton loginButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public Headers getPageHeader() {
        return pageHeader;
    }

    public ObjectToPurchase getPageObjectToPurchase() {
        return pageObjectToPurchase;
    }

    public LoginButton getLoginButton() {
        return loginButton;
    }

    public SidebarLinks getSidebarLinks() {
        return sidebarLinks;
    }
}
