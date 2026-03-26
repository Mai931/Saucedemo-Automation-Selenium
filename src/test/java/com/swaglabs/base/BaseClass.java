package com.swaglabs.base;

import com.swaglabs.factory.DriverFactory;
import com.swaglabs.pages.*;
import com.swaglabs.utils.Utilties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseClass extends DriverFactory {
    Utilties utils;
    protected String URL="https://www.saucedemo.com/";
    // String expectedURL="";
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected JavascriptExecutor jse;
    protected Actions actions;
    public LoginPage loginPage;
    public CartPage cartPage;
    public CheckOutInformationPage checkOutInformationPage;
    public ProductPage productPage;
    public CheckOutOverviewPage checkOutOverviewPage;
    public CheckOutCompletePage checkOutCompletePage;
    @BeforeClass
    public void setUp() throws Exception {

        driver=new DriverFactory().getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(URL);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
    @AfterMethod
    private void afterExecution(ITestResult testResult) throws IOException {


        utils = new Utilties();

        if (testResult.getStatus() == ITestResult.FAILURE) {
            utils.takeScreenshot(driver, testResult.getMethod().getMethodName());
        }

    }

}
