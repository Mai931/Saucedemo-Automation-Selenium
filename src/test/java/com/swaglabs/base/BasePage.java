package com.swaglabs.base;

import com.swaglabs.wrapers.Methods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Methods {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions actions;
    //Methods methods=new Methods();
    protected JavascriptExecutor jse;
    public BasePage(WebDriver driver,WebDriverWait wait,JavascriptExecutor jse,Actions actions){
        super(driver,wait,jse,actions);
        this.actions=actions;
        this.jse=jse;
        this.wait=wait;
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}

