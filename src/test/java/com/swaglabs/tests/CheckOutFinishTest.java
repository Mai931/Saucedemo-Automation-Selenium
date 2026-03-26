package com.swaglabs.tests;

import com.swaglabs.base.BaseClass;
import com.swaglabs.extentreports.TestListener;
import com.swaglabs.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CheckOutFinishTest extends BaseClass {
    @BeforeClass
    public void setupCheckout() {
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendUserName("standard_user");
        loginPage.sendPassWord("secret_sauce");
        loginPage.clickLogin();
        productPage=new ProductPage(driver,wait,jse,actions);
        productPage.addMultipleProducts(3);
        productPage.clickCartIcon();
        cartPage=new CartPage(driver,wait,jse,actions);
        cartPage.checkout();
        checkOutInformationPage=new CheckOutInformationPage(driver,wait,jse,actions);
        checkOutOverviewPage= new CheckOutOverviewPage(driver,wait,jse,actions);
        checkOutCompletePage = new CheckOutCompletePage(driver,wait,jse,actions);
        checkOutInformationPage.fillInformation("Mai", "QA", "12345");
        checkOutInformationPage.continueCheckout();

    }
    @Test(groups = "Checkout")
    public void verifySuccessfulCheckout() {

        checkOutOverviewPage.clickFinish();

        Assert.assertTrue(checkOutCompletePage.isOnCompletePage());
        Assert.assertEquals(
                checkOutCompletePage.getSuccessMessage(), "Thank you for your order!");
    }

}
