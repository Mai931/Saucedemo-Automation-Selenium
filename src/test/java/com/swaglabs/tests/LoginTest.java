package com.swaglabs.tests;

import com.swaglabs.base.BaseClass;
import com.swaglabs.extentreports.TestListener;
import com.swaglabs.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseClass {
    @DataProvider(name = "validUsers")
    public Object[][] validUsers(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
        {"performance_glitch_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"error_user","secret_sauce"},
                {"visual_user","secret_sauce"}
    };}
@Test(dataProvider = "validUsers")
    public void validLogin(String username,String password) throws InterruptedException {
    driver.get(URL);
    loginPage=new LoginPage(driver,wait,jse,actions);
    loginPage.sendUserName(username);
    loginPage.sendPassWord(password);
    loginPage.clickLogin();
    Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));


}
@Test
    public void invalidLoginWithBlockedUser(){
    driver.get(URL);
    loginPage=new LoginPage(driver,wait,jse,actions);
    loginPage.sendUserName("locked_out_user");
    loginPage.sendPassWord("secret_sauce");
    loginPage.clickLogin();
    Assert.assertTrue(URL.equals(driver.getCurrentUrl()));

}
@Test
    public void invalidLoginWithEmptyUserName(){
        driver.get(URL);
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendPassWord("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(URL.equals(driver.getCurrentUrl()));

    }
@Test
    public void invalidLoginWithEmptyPassWord(){
        driver.get(URL);
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendUserName("locked_out_user");
        loginPage.clickLogin();
        Assert.assertTrue(URL.equals(driver.getCurrentUrl()));

    }
@Test
    public void invalidLoginWithEmptyFields(){
        driver.get(URL);
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.clickLogin();
        Assert.assertTrue(URL.equals(driver.getCurrentUrl()));

    }
@Test
    public void invalidLoginWithWrongPassWord(){
        driver.get(URL);
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendUserName("standard_user");
        loginPage.sendPassWord("secret");
        loginPage.clickLogin();
        Assert.assertTrue(URL.equals(driver.getCurrentUrl()));

    }
@Test
    public void invalidLoginWithWrongUsername(){
        driver.get(URL);
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendUserName("user");
        loginPage.sendPassWord("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(URL.equals(driver.getCurrentUrl()));

    }
}




