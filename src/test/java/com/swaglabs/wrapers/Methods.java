package com.swaglabs.wrapers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Methods {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor jse;

    public Methods(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions){
        this.actions=actions;
        this.jse=jse;
        this.wait=wait;
        this.driver=driver;
    }


    public  void click(WebElement element){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        element.click();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public  void click(By by){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public  void input(WebElement element,String text){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        element.sendKeys(text);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            String result=element.getText();
            Assert.assertEquals(result,text);
        } catch (AssertionError e) {
            element.clear();
        }


    }
    public  void input(By by,String text){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            String result=wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
            Assert.assertEquals(result,text);
        } catch (AssertionError e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
        }


    }
    public  void scrollToElement(WebElement element){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jse.executeScript("arguments[0].scrollIntoView(true)",element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    public  void scrollToElement(By by){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        jse.executeScript("arguments[0].scrollIntoView(true)",element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public  void scroll(int x,int y){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jse.executeScript("window.scrollBy("+x+","+y+")");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public  void clickJs(WebElement element){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jse.executeScript("arguments[0].click();",element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public  void clickJs(By by){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        jse.executeScript("arguments[0].click();",element);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
