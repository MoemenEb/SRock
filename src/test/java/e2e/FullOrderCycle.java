package e2e;

import objects.page.CartPage;
import objects.page.HomePage;
import objects.page.Product;
import objects.widget.forms.PlaceOrderForm;
import org.testng.annotations.Test;
import utils.TestInit;

public class FullOrderCycle extends TestInit {
    private HomePage homePage;
    private CartPage cartPage;
    private Product productPage;
    private PlaceOrderForm placeOrderForm;

    @Test
    public void fullOrderCycle() {
        homePage = new HomePage(getWebDriver());
        homePage.getCategoriesList().listPhones();
        String searchProduct = "Nexus 6";
        productPage = homePage.getCategoriesSection().openProductWithName(searchProduct);
        productPage.addToCart();
        softAssert.assertTrue(productPage.productAddedToCart());
        productPage.closeAlert();
        cartPage = homePage.getNavBar().navToCart();
        placeOrderForm = cartPage.placeOrder();
        placeOrderForm.isModalVisible();
        placeOrderForm.setName("test");
        placeOrderForm.setCard("123");
        placeOrderForm.doPurchase();
        softAssert.assertTrue(placeOrderForm.getPurchaseAlertHeader().equals(placeOrderForm.getPurchaseDone()));
        softAssert.assertAll();
    }

}
