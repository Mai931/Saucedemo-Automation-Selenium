package com.swaglabs.pages;

import com.swaglabs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage   {
    public CartPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions) {
        super(driver, wait, jse, actions);
    }
    @FindBy
    By cartItemsNames=By.className("inventory_item_name");
    @FindBy
    By cartItemsPrices=By.className("inventory_item_price");
    @FindBy
    By removeButtons=By.cssSelector( "button[data-test^='remove']");
    @FindBy
    By checkOutButton=By.id("checkout");
    @FindBy
    By continueShoppingButton=By.id("continue-shopping");
    @FindBy
    By cartTitle = By.className("title");
    public String getCartPageTitle() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(cartTitle)).getText();
    }
    public List<WebElement> getAllCartItemsNames(){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemsNames));
    }
    public List<Double> getAllCartItemsPrices(){
        List<WebElement> prices= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemsPrices));
        return prices.stream().map(e->Double.parseDouble(e.getText().replace("$",""))).collect(Collectors.toList());
    }
    public List<WebElement> getAllRemoveButtons(){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeButtons));
    }
    public void removeItemWithName(String name){
        for (WebElement item:getAllCartItemsNames()){
            if (item.getText().equals(name)){
                wait.until(ExpectedConditions.elementToBeClickable(item.findElement(removeButtons))).click();
            }

        }
    }
    public int getCartItemsCount(){

        return getAllCartItemsNames().size();
    }
    //@to be reviewed
    public void removeAllItems(){

        for (WebElement item:getAllRemoveButtons()){
            click(item);

        }

    }
    public void removeFirstItem() {
        click( getAllRemoveButtons().getFirst());
    }
    public void checkout(){

        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();
    }
    public void continueShopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }
    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("cart");
    }
    public boolean isRemoveButtonDisplayed() {

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(removeButtons));
    }


}
