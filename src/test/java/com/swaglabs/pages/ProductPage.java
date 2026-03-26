package com.swaglabs.pages;

import com.swaglabs.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor jse, Actions actions) {
        super(driver, wait, jse, actions);
    }
    @FindBy
    By productImages = By.className("inventory_item_img");
    @FindBy
    By removeButtons = By.xpath("//button[contains(text(),'Remove')]");
    @FindBy
    By cartIcon=By.className("shopping_cart_link");
    @FindBy
    By cartBadge = By.className("shopping_cart_badge");
    @FindBy
    By menuIcon=By.id("react-burger-menu-btn");
    @FindBy
    By logoutLink = By.id("logout_sidebar_link");
    @FindBy
    By sortContainer=By.className("product_sort_container");
    @FindBy
    By productNames=By.className("inventory_item_name");
    @FindBy
    By productPrices=By.className("inventory_item_price");
    @FindBy
    By addToCartButtons=By.xpath("//button[contains(text(),'Add to cart')]");
    @FindBy
    By pageTitle=By.className("title");

    public List<WebElement> getAllProductPrices(){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrices));
    }
    public List<WebElement> getAllProductNames(){
     return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
    }
    public void clickAllProducts(){
        List<WebElement> productList= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));

        for (WebElement product: productList){

            click(product);
        }
    }
    public void clickFirstProduct(){
        List<WebElement> productList= wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));

            click(productList.getFirst());

    }
    public void sortAToZ(){
        WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(sortContainer));
        Select select=new Select(sort);
        select.selectByValue("az");
    }
    public void sortZToA(){
        WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(sortContainer));
        Select select=new Select(sort);
        select.selectByValue("za");
    }
    public void sortLowToHigh(){
        WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(sortContainer));
        Select select=new Select(sort);
        select.selectByValue("lohi");
    }
    public void sortHighToLow(){
        WebElement sort=wait.until(ExpectedConditions.visibilityOfElementLocated(sortContainer));
        Select select=new Select(sort);
        select.selectByValue("hilo");
    }
    public void addMultipleProducts(int number){
        List<WebElement> addToCartBtns=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        for (int i=0;i<number;i++){
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtns.get(i))).click();


        }

    }
    public void addAllProducts(){
        List<WebElement> addToCartBtns=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        for (WebElement button: addToCartBtns){
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();


        }


    }
    public void addProductWithIndex(int index){
        List<WebElement> addToCartBtns=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));

        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtns.get(index))).click();




    }
    public void addProductWithName(String name){
        for (WebElement productName : getAllProductNames())
            if (productName.getText().equals(name)) {
                WebElement productButton = productName.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
                wait.until(ExpectedConditions.elementToBeClickable(productButton)).click();
                break;
            }




    }
    public void removeMultipleProducts(int number){
        List<WebElement> addToCartBtns=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeButtons));
        for (int i=0;i<number;i++){
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtns.get(i))).click();


        }

    }
    public void removeAllProducts() {
        List<WebElement> addToCartBtns=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeButtons));
        for (WebElement button: addToCartBtns){
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();


        }
    }
    public void clickCartIcon(){
        click(cartIcon);
    }
    public void logout(){
        click(menuIcon);
        click(logoutLink);
    }
    public String getPageTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public void removeProductWithIndex(int index){
        List<WebElement> addToCartBtns=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(removeButtons));

            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtns.get(index))).click();




    }
    public void removeProductWithName(String name){
    for (WebElement productName : getAllProductNames())
        if (productName.getText().equals(name)) {
            WebElement productButton = productName.findElement(By.xpath("//button[contains(text(),'Remove')]"));
            wait.until(ExpectedConditions.elementToBeClickable(productButton)).click();
            break;
        }




    }
    public boolean isCartIconDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon)).isDisplayed();
    }
    public boolean isSortingDropdownDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(sortContainer)).isDisplayed();
    }
    public boolean areProductNamesUnique() {
        return getAllProductNames().stream().distinct().count() == getAllProductNames().size();

    }

    public boolean isPriceFormatCorrect() {
        return getAllProductPrices()
                .stream()
                .allMatch(p -> p.getText().startsWith("$"));
    }
    public boolean areImagesDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productImages))
                .stream()
                .allMatch(WebElement::isDisplayed);
    }
    public boolean isRemoveButtonDisplayed() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeButtons)).isDisplayed();
    }
    public boolean isSortedByNameAscending() {

        List<String> actual = getAllProductNames()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        return actual.equals(sorted);
    }

    public boolean isSortedByNameDescending() {

        List<String> actual = getAllProductNames()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sorted = new ArrayList<>(actual);
        sorted.sort(Collections.reverseOrder());

        return actual.equals(sorted);
    }

    public boolean isSortedByPriceAscending() {

        List<Double> actual = getAllProductPrices()
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());

        List<Double> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        return actual.equals(sorted);
    }

    public boolean isSortedByPriceDescending() {

        List<Double> actual =getAllProductPrices()
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());

        List<Double> sorted = new ArrayList<>(actual);
        sorted.sort(Collections.reverseOrder());

        return actual.equals(sorted);
    }
    public int getCartCount() {
        try {
            return Integer.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
    public boolean isCartBadgeDesplayed(){
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(cartBadge));
        }catch (TimeoutException e){
            return false;
        }
    }
    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("cart");
    }
    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("saucedemo.com");
    }
    public boolean isOnProductDetailsPage() {
        return driver.getCurrentUrl().contains("inventory-item");
    }






}
