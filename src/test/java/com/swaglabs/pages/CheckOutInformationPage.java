package com.swaglabs.pages;

import com.swaglabs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutInformationPage extends BasePage {
    public CheckOutInformationPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions) {
        super(driver, wait, jse, actions);
    }
    @FindBy
    By firstName=By.id("first-name");
    @FindBy
    By lastName=By.id("last-name");
    @FindBy
    By zipCode=By.id("postal-code");
    @FindBy
    By cancelButton=By.id("cancel");
    @FindBy
    By continueButton=By.id("continue");
    @FindBy
    By errorMsg = By.cssSelector("h3[data-test='error']");
    public void fillInformation(String fName,String lName, String code){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        input(firstName,fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).clear();
        input(lastName,lName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).clear();
        input(zipCode,code);

    }
    public void clearData(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).clear();

    }
    public void cancel(){

        click(cancelButton);
    }
    public void continueCheckout(){

        click(continueButton);
    }
    public String getErrorMessage(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }
    public boolean isOnStepOnePage() {
        return driver.getCurrentUrl().contains("checkout-step-one");
    }

}
