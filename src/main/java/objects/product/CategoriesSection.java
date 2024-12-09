package objects.product;

import objects.page.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoriesSection {
    private WebDriver driver;
    final By SectionDIV = By.id("tbodyid");
    final By ItemDiv = By.cssSelector(".col-lg-4.col-md-6.mb-4");
    final By Card = By.className("card-block");
    private WebDriverWait wait;
    final By CardTitle = By.tagName("h4");



    public CategoriesSection(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement findCardObject(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Card));
        return listItems().get(index).findElement(Card);
    }

    public WebElement findProductCardWithName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Card));
        for (WebElement card : listItems()) {
            if (card.findElement(CardTitle).getText().equalsIgnoreCase(name))
                return card.findElement(Card);
        }
        throw new RuntimeException("No card found with name: " + name);
    }

    public List<WebElement> listItems(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SectionDIV));
        WebElement parent = driver.findElement(SectionDIV);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ItemDiv));
        return parent.findElements(ItemDiv);
    }

    public Product openProduct(int index){
        findCardObject(index).findElement(CardTitle).click();
        return new Product();
    }

    public Product openProductWithName(String name) {
        findProductCardWithName(name).findElement(By.linkText(name)).click();
        return new Product();
    }
}

