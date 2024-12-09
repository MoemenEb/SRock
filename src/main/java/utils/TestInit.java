package utils;


import objects.page.HomePage;
import objects.page.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class TestInit {

    private static WebDriver webDriver;
    protected Page homePage;
    protected static final SoftAssert softAssert = new SoftAssert();
    private final Logger logger = LogManager.getLogger(TestInit.class);

    @BeforeClass(alwaysRun = true)
    public void setup() {
        logger.info("Before Class - Setup method");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.get(homePage.getUrl());
    }

    @AfterClass
    public void finishTest(){
        logger.info("After Class - Quit Chrome");
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
