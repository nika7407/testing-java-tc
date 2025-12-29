package com.solvd.testing.web.firstlink.uiobject;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SidebarLinks extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(text(),'About Us')]")
    private ExtendedWebElement aboutUs;

    @FindBy(xpath = ".//*[contains(text(),'Catalog')]")
    private ExtendedWebElement catalog;

    @FindBy(xpath = ".//*[contains(text(),'Blog')]")
    private ExtendedWebElement blog;

    public SidebarLinks(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAboutUs() {
        return aboutUs;
    }

    public ExtendedWebElement getCatalogLink() {
        return catalog;
    }

    public ExtendedWebElement getBlogLink() {
        return blog;
    }

    public void clickAboutUsLink() {
        getAboutUs().hover();
        getAboutUs().click();
    }

    public void clickCatalogLink() {
        getCatalogLink().hover();
        getCatalogLink().click();
    }

    public void clickBlogLink() {
        getBlogLink().hover();
        getBlogLink().click();
    }
}
