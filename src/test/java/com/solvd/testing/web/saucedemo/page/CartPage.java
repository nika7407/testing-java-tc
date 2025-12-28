package com.solvd.testing.web.saucedemo.page;

import com.solvd.testing.web.saucedemo.uiobject.CartList;
import com.solvd.testing.web.saucedemo.uiobject.LoginForm;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class CartPage extends AbstractPage {

    @FindBy(className = "cart_list")
    private CartList cartList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartList getCartList() {
        return cartList;
    }
}
