package com.swaglabs.pages;

import com.swaglabs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutCompletePage extends BasePage {
    public CheckOutCompletePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions) {
        super(driver, wait, jse, actions);
    }
    @FindBy
    By successMessage = By.className("complete-header");
    @FindBy
    By backHomeBtn = By.id("back-to-products");
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
    public boolean isOnCompletePage() {
        return driver.getCurrentUrl().contains("checkout-complete");
    }
    public void clickBackHome() {
        driver.findElement(backHomeBtn).click();
    }


}
