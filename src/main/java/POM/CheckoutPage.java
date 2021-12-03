package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    protected Homepage homepage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDeliveryAddress(String fName, String lName, String no, String street, String city) throws InterruptedException {
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

    //Select address on Address book page
    public void selectAddress() throws InterruptedException {
        driver.findElement(By.name("selectDeliveryAddress")).click();

        //Use this address button
        driver.findElement(By.cssSelector("._2aac2_3bwnD ._841f1_1RZK9")).click();

        //Select Pay Now
        driver.findElement(By.name("selectPaymentMethod")).click();


        //Continue to Payment button
        driver.findElement(By.name("placeOrder")).click();
    }

    public void cardPaymentMethod(String cardNo, String expiryDate, String cvv) throws InterruptedException {
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
        driver.findElement(By.cssSelector("._12e27_1r3kc")).click();

        //Click Logout
        Thread.sleep(2000);
        System.out.println("Clicking Logout");
        driver.findElements(By.cssSelector(".de870_2eIHs")).get(9).click();
        System.out.println("Clicked Logout");
        Thread.sleep(5000);
        return new Homepage(driver);
    }
}
