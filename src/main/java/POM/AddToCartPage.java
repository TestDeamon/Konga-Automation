package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddToCartPage {
    private WebDriver driver;
    protected Homepage homepage;

    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    //Add Item to Cart
    public void addItemToCart() throws InterruptedException{
        //Select a Laptop to Add to Cart
        //Item one
        driver.findElements(By.className("_0a08a_3czMG")).get(1).click();
    }

    //Go To Cart
    public void checkout() throws InterruptedException{
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("._8486b_25fFV ._79484_1sLEt span")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("._2aac2_3bwnD  button")).click();
        Thread.sleep(3000);
    }
    //Go to CheckoutPage
    public void clickCheckoutBtn() throws InterruptedException{
        Thread.sleep(2000);

        //Close add phone number modal
        System.out.println("About to click close phone no modal");
        driver.findElement(By.cssSelector("._40e43_1f83p")).click();
//        driver.findElement(By.cssSelector("._40e43_1f83p span")).click();
        System.out.println("Clicked");
        //Choose Select Delivery Address
        System.out.println("Select Delivery address");
        driver.findElements(By.cssSelector("._549f7_zvZ8u ._0a08a_3czMG")).get(0).click();
//        driver.findElement(By.cssSelector("._2aac2_3bwnD ._549f7_zvZ8u ._6530d_2NZhJ")).click();
        System.out.println("Clicked");
        Thread.sleep(2000);
    }
    public void enterDeliveryAddress(String fName, String lName, String no, String street, String city) throws InterruptedException{
        Thread.sleep(1000);
        //Enter first name
        driver.findElement(By.id("firstname")).sendKeys(fName);
        Thread.sleep(1000);

        //Enter last name
        driver.findElement(By.id("lastname")).sendKeys(lName);
        Thread.sleep(1000);

        //Enter Mobile No
        driver.findElement(By.id("telephone")).sendKeys(no);
        Thread.sleep(1000);

        //Enter Street Address
        driver.findElement(By.id("street")).sendKeys(street);
        Thread.sleep(1000);

        //Enter city
        driver.findElement(By.id("city")).sendKeys(city);
        Thread.sleep(1000);

        //Scroll down to Find Other elements on the Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.name("saveDeliveryAddress"));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        //Select State
        Select state = new Select(driver.findElement(By.name("regionId")));
        state.selectByValue("1061493616");
        Thread.sleep(1000);

        //Select Local Government Area
        Select lga = new Select(driver.findElement(By.name("areaId")));
        lga.selectByValue("22");
        Thread.sleep(1000);

        //Click Next Button
        driver.findElement(By.name("saveDeliveryAddress")).click();
    }

    public void clickPayNow(String cardNo, String expiryDate, String cvv) throws InterruptedException{
        Thread.sleep(2000);

        System.out.println("Inside Click Pay now ");
        //Click use this address button
        System.out.println("About to Click Use this address");
        driver.findElement(By.tagName("button")).click();
        System.out.println("About to Click Use this address");
        Thread.sleep(3000);

        //Choose Select Delivery Address
        System.out.println("Select Delivery address");
        driver.findElements(By.cssSelector("._549f7_zvZ8u ._0a08a_3czMG")).get(0).click();

        //Select Pay Now
        driver.findElement(By.name("selectPaymentMethod")).click();

        driver.findElement(By.cssSelector("._2aac2_3bwnD button:active")).click();

        //Select continue to Pay
        System.out.println("Continue to pay");
        driver.findElement(By.cssSelector("._9b954_8rPAx .f082d_safAL button")).click();
        System.out.println("Continue to pay");

        Thread.sleep(3000);


        //Select Payment Method
        System.out.println("Select payment method");

        //Second select address
        driver.findElement(By.cssSelector("._0a08a_3czMG ._7e22a_3zNWE")).click();

        System.out.println("About to Click Use this address");
        driver.findElement(By.tagName("button")).click();


        driver.findElement(By.cssSelector(".dashboard-card .payment-option-content")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("card-number")).sendKeys(cardNo);
        driver.findElement(By.id("expiry")).sendKeys(expiryDate);
        driver.findElement(By.id("cvv")).sendKeys(cvv);
        Thread.sleep(2000);
        pin();
        driver.findElement(By.id("validateCardForm")).click();

        //Close Error Message
        driver.findElement(By.cssSelector(".data-card__close")).click();
        Thread.sleep(3000);
        /*
        Thread.sleep(3000);

//        driver.findElement(By.cssSelector("._40e43_1f83p span")).click();

//        Select Select Delivery Address button
//        driver.findElement(By.cssSelector("._0a08a_3czMG ._7e22a_3zNWE")).click();
//        Thread.sleep(3000);

//        //Select Address
//        driver.findElement(By.cssSelector("._881fb_F6tni._3d909_3vElz")).click();


        //Click use this address button
        driver.findElement(By.cssSelector("._841f1_1RZK9 ._0a08a_3czMG")).click();

        //Select Pay Now
        driver.findElement(By.name("selectPaymentMethod")).click();
//        driver.findElement(By.cssSelector("._54332_1WUdf ._4a291_2cOtr")).click();

        //Select continue to Pay
        driver.findElement(By.cssSelector("._9b954_8rPAx .f082d_safAL button")).click();

        //Select Payment Method
        driver.findElement(By.cssSelector(".dashboard-card .payment-option-content")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("card-number")).sendKeys(cardNo);
        driver.findElement(By.id("expiry")).sendKeys(expiryDate);
        driver.findElement(By.id("cvv")).sendKeys(cvv);
        Thread.sleep(2000);
        pin();
        driver.findElement(By.id("validateCardForm")).click();

        //Close Error Message
        driver.findElement(By.cssSelector(".data-card__close")).click();
        Thread.sleep(3000);
        */
    }
    private void pin() throws InterruptedException{
        List<WebElement> el = driver.findElements(By.cssSelector(".pin-keypad__button"));
        el.get(3).click();
        el.get(1).click();
        el.get(9).click();
        el.get(0).click();
    }

    public Homepage logOut() throws InterruptedException {
        //Click my account
        driver.findElement(By.cssSelector("._3b382_2WveR")).click();

        //Click Logout
        driver.findElement(By.cssSelector(".de870_2eIHs a")).click();
        return new Homepage(driver);
    }

}
