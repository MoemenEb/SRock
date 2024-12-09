package objects.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CategoriesList {

    private WebDriver driver;
    final By Phones = By.linkText("Phones");
    final By Laptops = By.linkText("Laptops");
    final By Monitors = By.linkText("Monitors");
    private WebDriverWait wait;

    public CategoriesList(WebDriver webDriver) {

        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void listPhones(){
       wait.until(
                ExpectedConditions.visibilityOfElementLocated(Phones));
        driver.findElement(Phones).click();
    }

    public void listLaptops(){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(Laptops));
        driver.findElement(Laptops).click();
    }

    public void listMonitors(){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(Monitors));
        driver.findElement(Monitors).click();
    }
}
