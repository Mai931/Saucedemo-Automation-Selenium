package com.swaglabs.tests;

import com.swaglabs.base.BaseClass;
import com.swaglabs.extentreports.TestListener;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CartPageTest extends BaseClass {

    @BeforeClass
    public void setupCart() {

        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendUserName("standard_user");
        loginPage.sendPassWord("secret_sauce");
        loginPage.clickLogin();
        productPage=new ProductPage(driver,wait,jse,actions);
        productPage.addMultipleProducts(2);
        productPage.clickCartIcon();
        cartPage=new CartPage(driver,wait,jse,actions);
    }
    @Test(groups = "CartUI")
    public void verifyCartPageTitle() {
        Assert.assertEquals(cartPage.getCartPageTitle(), "Your Cart");
    }

    @Test(groups = "CartUI")
    public void verifyCartPageURL() {
        Assert.assertTrue(cartPage.isOnCartPage());
    }
    @Test(groups = "CartData")
    public void verifyItemsCountInCart() {
        Assert.assertEquals(cartPage.getCartItemsCount(), 2);
    }

    @Test(groups = "CartData")
    public void verifyItemNamesNotEmpty() {
        Assert.assertTrue(cartPage.getAllCartItemsNames().size() > 0);
    }

    @Test(groups = "CartData")
    public void verifyPricesArePositive() {

        cartPage.getAllCartItemsPrices()
                .forEach(price -> Assert.assertTrue(price > 0));
    }
    @Test(groups = "CartActions")
    public void verifyRemoveSingleItem() {
        driver.navigate().back();
        productPage.addMultipleProducts(2);
        productPage.clickCartIcon();
        cartPage.removeFirstItem();
        Assert.assertEquals(cartPage.getCartItemsCount(), 1);
    }

    @Test(groups = "CartActions")
    public void verifyRemoveAllItems() {

        cartPage.removeAllItems();
        Assert.assertTrue((cartPage.isRemoveButtonDisplayed()));
    }


}
