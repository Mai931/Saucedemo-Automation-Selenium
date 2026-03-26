package com.swaglabs.pages;

import com.swaglabs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions) {
        super(driver, wait, jse, actions);
    }
    @FindBy
    By userName=By.id("user-name");
    @FindBy
    By passWord=By.id("password");
    @FindBy
    By loginButton=By.id("login-button");
    public void sendUserName(String name){
        input(userName,name);

    }
    public void sendPassWord(String pass){
        input(passWord,pass);

    }
    public void clickLogin(){
        click(loginButton);
    }

}
