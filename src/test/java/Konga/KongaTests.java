package Konga;

import POM.*;
import Setup.SetupTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class KongaTests extends SetupTest {
    private WebDriver driver;

    LoginPage loginPage;
    Searchpage searchpage;
    CheckoutPage checkoutPage;
    AddToCartPage addToCartPage;

    @Test(priority = 0)
    public void testHomepage() throws InterruptedException{
//        homepage.getPageTitle();
        loginPage = homepage.clickLoginNdSignup();
    }

    @Test(priority = 1)
    public void testLoginPage() throws InterruptedException {
        loginPage.enterUsername("clairedavis@mailinator.com");
        loginPage.enterPassword("clairedavis@mailinator.com");
        searchpage = loginPage.sendDetailsToLogin();

        searchpage.clickCompNdAccessories();
        Thread.sleep(2000);
        searchpage.clickLaptopSubcategory();
    }

    @Test(priority = 2)
    public void testSearchPage() throws InterruptedException {
        addToCartPage = searchpage.navigateToAppleLaptops();
        addToCartPage.addItemToCart();
        Thread.sleep(3000);
        System.out.println("About to click Add To Cart Page");
        addToCartPage.checkout();
        checkoutPage = addToCartPage.clickCheckoutBtn();
        System.out.println("Add To Cart Page");
        Thread.sleep(3000);
    }


    @Test(priority = 3)
    public void testCheckoutPage() throws InterruptedException {
        checkoutPage.enterDeliveryAddress("Elizabeth", "Alola", "08100044638", "Agbowo", "Ibadan");
        Thread.sleep(3000);
        checkoutPage.selectAddress();
        Thread.sleep(3000);
        checkoutPage.cardPaymentMethod("5423456789902346", "11/20", "219");
        Thread.sleep(5000);
//        homepage = checkoutPage.logOut();
    }



}
