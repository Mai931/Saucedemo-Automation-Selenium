package com.swaglabs.tests;

import com.swaglabs.base.BaseClass;
import com.swaglabs.extentreports.TestListener;
import com.swaglabs.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CheckOutStepOneTest extends BaseClass {

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

    }
    @Test
    public void verifyStepOnePageLoads() {

        Assert.assertTrue(checkOutInformationPage.isOnStepOnePage());
    }
    @Test
    public void verifyErrorWhenFirstNameEmpty()  {
        checkOutInformationPage.fillInformation("", "QA", "12345");
        checkOutInformationPage.continueCheckout();
        Assert.assertTrue(checkOutInformationPage.getErrorMessage().contains("First Name"));
        driver.navigate().refresh();





    }
    @Test
    public void verifyErrorWhenLastNameEmpty() {

        checkOutInformationPage.fillInformation("QA", "", "12345");
        checkOutInformationPage.continueCheckout();

        Assert.assertTrue(checkOutInformationPage.getErrorMessage().contains("Last Name"));
        driver.navigate().refresh();


    }
    @Test
    public void verifyErrorWhenPostalCodeEmpty()  {

        checkOutInformationPage.fillInformation("Mai", "Atef","");
        checkOutInformationPage.continueCheckout();

        Assert.assertTrue(checkOutInformationPage.getErrorMessage().contains("Postal Code"));
        driver.navigate().refresh();

    }
    @Test
    public void verifyContinueWithValidData()  {

        checkOutInformationPage.fillInformation("Mai", "Atef","");
        checkOutInformationPage.continueCheckout();

        Assert.assertTrue(checkOutInformationPage.getErrorMessage().contains("Postal Code"));
        driver.navigate().refresh();

    }
    @Test
    public void verifyOverviewPageLoads() {

        checkOutInformationPage.fillInformation("Mai", "QA", "12345");
        checkOutInformationPage.continueCheckout();

        Assert.assertTrue(checkOutOverviewPage.isOnOverviewPage());
        Assert.assertTrue(!checkOutOverviewPage.getOverviewItemNames().isEmpty());
        driver.navigate().back();
    }
    @Test
    public void verifyCancelButtonNavigation() {
        checkOutInformationPage.fillInformation("Mai", "QA", "12345");
        checkOutInformationPage.continueCheckout();
        checkOutOverviewPage.clickCancel();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        productPage.clickCartIcon();
        cartPage.checkout();

    }







}
