package com.solvd.testing.web.firstLink.page;

import com.solvd.testing.web.firstLink.uiobject.CartPageItem;
import com.solvd.testing.web.firstLink.uiobject.CheckoutButton;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'omega') and contains(@class,'alpha') and contains(@class,'column') and contains(@class,'twelve')]/div[contains(@class, 'row')]")
    private CartPageItem cartPageItem;

    @FindBy(xpath = "//div[@class='six columns omega actions']")
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
