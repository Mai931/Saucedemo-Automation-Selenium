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

public class CheckOutOverviewPage extends BasePage {
    public CheckOutOverviewPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions) {
        super(driver, wait, jse, actions);
    }
    @FindBy
    By finishBtn = By.id("finish");
    @FindBy
    By totalPrice = By.className("summary_total_label");
    @FindBy
    By subTotal=By.className("summary_subtotal_label");
    @FindBy
    By cancelBtn = By.id("cancel");
    @FindBy
    By itemNames = By.className("inventory_item_name");
    @FindBy
    By itemPrices = By.className("inventory_item_price");
    @FindBy
    By taxLabel=By.className("summary_tax_label");

    public List<String> getOverviewItemNames() {
        List<WebElement> names= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemNames));
        return names.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<Double> getOverviewItemPrices() {
        List<WebElement> prices= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemPrices));
        return prices.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());

    }
    public double calculateAllPrices(){
        double sum = 0.0;

        for (double price : getOverviewItemPrices()) {

            sum += price;
        }
        return sum;
    }
    public double getSubTotalPrice() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(subTotal)).getText().replace("Item total: $",""));
    }
    public double getTotalPrice() {
        return Double.parseDouble(wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText().replace("Total: $",""));
    }
    public double getTax() {
        return Double.parseDouble(
                wait.until(ExpectedConditions.visibilityOfElementLocated(taxLabel)).getText().replace("Tax: $", "")
        );
    }
    public void clickFinish() {

        click(finishBtn);
    }
    public void clickCancel() {
        driver.findElement(cancelBtn).click();
    }
    public boolean isOnOverviewPage() {
        return driver.getCurrentUrl().contains("checkout-step-two");
    }
}
