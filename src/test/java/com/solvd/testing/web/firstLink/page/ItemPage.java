package com.solvd.testing.web.firstLink.page;

import com.solvd.testing.web.firstLink.uiobject.AddButton;
import com.solvd.testing.web.firstLink.uiobject.Headers;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(id = "product-form")
    private AddButton addButton;

    @FindBy(id = "minicart")
    private Headers pageHeader;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public AddButton getAddButton() {
        return addButton;
    }

    public Headers getPageHeader() {
        return pageHeader;
    }


}
