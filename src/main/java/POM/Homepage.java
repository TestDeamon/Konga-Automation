package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    private WebDriver driver;
    protected LoginPage loginPage;
    private String pageTitle = "";


    public Homepage(WebDriver driver){
        this.driver = driver;
    }

    //Get and Print page Title
    public void getPageTitle(){
        pageTitle = driver.getTitle();
        System.out.println("Page title is: "+pageTitle);
    }

    //Click login/Signup Button then return to login Page
    public LoginPage clickLoginNdSignup() throws InterruptedException{
        driver.findElement(By.className("_12e27_1r3kc")).click();
        return new LoginPage(driver);
    }

}
