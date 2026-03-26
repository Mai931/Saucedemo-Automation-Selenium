package com.swaglabs.tests;

import com.swaglabs.base.BaseClass;
import com.swaglabs.extentreports.TestListener;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(TestListener.class)
public class ProductPageTest extends BaseClass {


    @BeforeClass
    public void login() {
        loginPage=new LoginPage(driver,wait,jse,actions);
        loginPage.sendUserName("standard_user");
        loginPage.sendPassWord("secret_sauce");
        loginPage.clickLogin();
        productPage = new ProductPage(driver,wait,jse,actions);
    }
    @Test(groups = "UI")
    public void verifyPageTitle() {
        Assert.assertEquals(productPage.getPageTitle(), "Products");
    }

    @Test(groups = "UI")
    public void verifyProductsDisplayed() {
        System.out.println(productPage.getAllProductNames());
        Assert.assertTrue(!productPage.getAllProductNames().isEmpty());
    }

    @Test(groups = "UI")
    public void verifyProductsCountIsSix() {
        Assert.assertEquals(productPage.getAllProductNames().size(), 6);
    }

    @Test(groups = "UI")
    public void verifyCartIconVisible() {
        Assert.assertTrue(productPage.isCartIconDisplayed());
    }
    @Test(groups = "Data")
    public void verifyProductNamesUnique() {
        Assert.assertTrue(productPage.areProductNamesUnique());
    }

    @Test(groups = "Data")
    public void verifyAllPricesDisplayed() {
        Assert.assertEquals(productPage.getAllProductPrices().size(),6);
    }

    @Test(groups = "Data")
    public void verifyPriceFormat() {
        Assert.assertTrue(productPage.isPriceFormatCorrect());
    }

    @Test(groups = "Data")
    public void verifyImagesDisplayed() {
        Assert.assertTrue(productPage.areImagesDisplayed());
    }

    @Test(groups = "UI")
    public void verifySortingDropdownVisible() {

        Assert.assertTrue(productPage.isSortingDropdownDisplayed());
    }
    @Test(groups = "Cart")
    public void verifyAddSingleProduct() {
        productPage.addMultipleProducts(1);
        Assert.assertEquals(productPage.getCartCount(), 1);
        productPage.removeMultipleProducts(1);
    }

    @Test(groups = "Cart")
    public void verifyAddMultipleProducts() {
        productPage.addMultipleProducts(3);
        Assert.assertEquals(productPage.getCartCount(), 3);
        productPage.removeMultipleProducts(3);
    }

    @Test(groups = "Cart")
    public void verifyAddAllProducts() {
        productPage.addAllProducts();
        Assert.assertEquals(productPage.getCartCount(), 6);
        productPage.removeAllProducts();
    }

    @Test(groups = "Cart")
    public void verifyButtonChangesToRemove() {
        productPage.addMultipleProducts(1);
        Assert.assertTrue(productPage.isRemoveButtonDisplayed());
        productPage.removeMultipleProducts(1);
    }
    @Test(groups = "Cart")
    public void verifyRemoveProduct() {
        productPage.addMultipleProducts(2);
        productPage.removeProductWithIndex(1);
        Assert.assertEquals(productPage.getCartCount(), 1);
        productPage.removeProductWithIndex(0);

    }

    @Test(groups = "Cart")
    public void verifyRemoveAllProducts() {
        productPage.addAllProducts();
        productPage.removeAllProducts();
        Assert.assertTrue(productPage.isCartBadgeDesplayed());
    }
    @Test(groups = "Sorting")
    public void verifySortByNameAZ() {
        productPage.sortAToZ();
        Assert.assertTrue(productPage.isSortedByNameAscending());
    }

    @Test(groups = "Sorting")
    public void verifySortByNameZA() {
        productPage.sortZToA();
        Assert.assertTrue(productPage.isSortedByNameDescending());
    }

    @Test(groups = "Sorting")
    public void verifySortByPriceLowHigh() {
        productPage.sortLowToHigh();
        Assert.assertTrue(productPage.isSortedByPriceAscending());
    }

    @Test(groups = "Sorting")
    public void verifySortByPriceHighLow() {
        productPage.sortHighToLow();
        Assert.assertTrue(productPage.isSortedByPriceDescending());
    }
    @Test(groups = "Navigation")
    public void verifyProductNameNavigation() {
        productPage.clickFirstProduct();
        Assert.assertTrue(productPage.isOnProductDetailsPage());
        driver.navigate().back();
    }

    @Test(groups = "Navigation")
    public void verifyCartNavigation() {
        productPage.clickCartIcon();
        Assert.assertTrue(productPage.isOnCartPage());
        driver.navigate().back();
    }

    @Test(groups = "Navigation")
    public void verifyLogoutFunctionality() {
        productPage.logout();
        Assert.assertTrue(productPage.isOnLoginPage());
        loginPage.sendUserName("standard_user");
        loginPage.sendPassWord("secret_sauce");
        loginPage.clickLogin();

    }
    @Test(groups = "Edge")
    public void verifyRefreshKeepsCart() {
        productPage.addMultipleProducts(2);
        driver.navigate().refresh();
        Assert.assertEquals(productPage.getCartCount(), 2);
        productPage.removeMultipleProducts(2);
    }

    @Test(groups = "Edge")
    public void verifyURLContainsInventory() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }


}


