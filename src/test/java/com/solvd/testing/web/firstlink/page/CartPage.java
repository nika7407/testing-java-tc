package com.solvd.testing.web.firstlink.page;

import com.solvd.testing.web.firstlink.uiobject.CartPageItem;
import com.solvd.testing.web.firstlink.uiobject.CheckoutButton;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'omega') and contains(@class,'alpha') and contains(@class,'column') and contains(@class,'twelve')]//*[contains(@class, 'row')]")
    private CartPageItem cartPageItem;

    @FindBy(xpath = "//*[contains(@class, 'six') and contains(@class, 'columns') and contains(@class, 'omega') and contains(@class, 'actions')]")
    private CheckoutButton checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPageItem getCartPageItem() {
        return cartPageItem;
    }

    public CheckoutButton getCheckoutButton() {
        return checkoutButton;
    }
}
