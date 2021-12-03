package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchpage {
    private WebDriver driver;
    protected AddToCartPage addToCartPage;

    public Searchpage(WebDriver driver){
        this.driver = driver;
    }

    //Click Computer Accessories in Navigation Menu
    public void clickCompNdAccessories(){
        driver.findElement(By.linkText("Computers and Accessories")).click();
    }

    //Click Subcategory computer and Laptops
    public void clickLaptopSubcategory() throws InterruptedException{
        Thread.sleep(6000);
        driver.findElement(By.linkText("Laptops")).click();
    }

    //Select Click on Apple Macbooks
    public AddToCartPage navigateToAppleLaptops() throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.linkText("Apple MacBooks")).click();
        Thread.sleep(1000);
        return new AddToCartPage(driver);
    }
}
