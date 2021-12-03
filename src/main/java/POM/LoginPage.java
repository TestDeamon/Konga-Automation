package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    protected Searchpage searchpage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Input email/phoneno
    public void enterUsername (String name) {
        driver.findElement(By.id("username")).sendKeys(name);
    }
    //Input Password
    public void enterPassword (String pwd) {
        driver.findElement(By.id("password")).sendKeys(pwd);
    }

    //Click Login button
    public Searchpage sendDetailsToLogin () throws InterruptedException {
        System.out.println("Sign In");
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]")).click();
        System.out.println("Sign In");
        //Sleep for 3 seconds
        Thread.sleep(3000);
        return new Searchpage(driver);
    }
}
