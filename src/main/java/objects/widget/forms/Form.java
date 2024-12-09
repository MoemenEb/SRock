package objects.widget.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Form {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    final By Form = By.cssSelector(".modal.fade.show");

    public Form(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    }


    public boolean isModalVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Form));
        return webDriver.findElement(Form).isDisplayed();
    }


    public String alertText(){
        wait.until(ExpectedConditions.alertIsPresent());
        return webDriver.switchTo().alert().getText();
    }

    public void closeForm(){
        webDriver.findElement(Form).sendKeys(Keys.ESCAPE);
    }

    public void closeAlert(){
        webDriver.switchTo().alert().accept();
    }
}
