package com.solvd.web.firstlink.page;

import com.solvd.web.firstlink.uiobject.Headers;
import com.solvd.web.firstlink.uiobject.ObjectToPurchase;
import com.solvd.web.firstlink.uiobject.SidebarLinks;
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

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public Headers getPageHeader() {
        return pageHeader;
    }

    public ObjectToPurchase getPageObjectToPurchase() {
        return pageObjectToPurchase;
    }

    public SidebarLinks getSidebarLinks() {
        return sidebarLinks;
    }
}
