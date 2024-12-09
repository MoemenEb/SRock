package registration;

import objects.widget.forms.LoginForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestInit;

public class LoginTest extends TestInit {
    private final Logger logger = LogManager.getLogger(LoginTest.class);
    private LoginForm loginForm;
    @BeforeMethod
    public void beforeMethod() {
        logger.info("Test started");
       loginForm = homePage.getNavBar().navToLogin();
       loginForm.clearForm();
    }

    @Test
    public void loginTest_invalidLogin() {
        logger.info("Test invalid login");
        loginForm.fullLogin("dummy","123");
        softAssert.assertTrue(loginForm.isLogginFail());
        loginForm.closeAlert();
        loginForm.closeForm();
        softAssert.assertAll();
    }

    @Test
    public void loginTest_validLogin() {
        logger.info("Test valid login");
        loginForm.fullLogin("mon1507", "mon1507");
        softAssert.assertTrue(homePage.getNavBar().isLoggedin());
        softAssert.assertTrue(homePage.getNavBar().getWelcomeMsg().contains("mon1507"));
        softAssert.assertAll();
    }
}
