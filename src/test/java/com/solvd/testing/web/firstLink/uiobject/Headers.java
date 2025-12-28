package com.solvd.testing.web.firstLink.uiobject;

import com.solvd.testing.web.firstLink.page.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Headers extends AbstractUIObject {


//          <div class="sauce-app-profile"></div>
//          <a href="#" class="toggle-drawer cart desktop ">My Cart <span id="cart-target-desktop" class="count cart-target">(0)</span></a>
//          <a href="/cart" class="cart mobile  cart-target">My Cart <span id="cart-target-mobile" class="count">(0)</span></a>
//          <a href="/cart" class="checkout">Check Out</a>


    @FindBy(xpath = ".//a[contains(@class,'toggle-drawer cart desktop ')]")
    private ExtendedWebElement cart;

    @FindBy(xpath = ".//a[contains(@class,'checkout')]")
    private ExtendedWebElement checkout;

    public Headers(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCart() {
        return cart;
    }

    public ExtendedWebElement getCheckout() {
        return checkout;
    }

    public CartPage pressCheckout(){
        getCheckout().hover();
        getCheckout().click();
        return new CartPage(driver);
    }


}
