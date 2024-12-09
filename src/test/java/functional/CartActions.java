package functional;

import objects.page.CartPage;
import objects.page.HomePage;
import objects.page.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestInit;

public class CartActions extends TestInit {
    private HomePage homePage;
    private CartPage cartPage;
    private Product productPage;


    @BeforeMethod
    public void setupMethod(){
        homePage = new HomePage(getWebDriver());
        getWebDriver().get(homePage.getUrl());
    }

    @Test
    public void addProductToCart(){
        homePage.getCategoriesList().listPhones();
        String searchProduct = "Nexus 6";
        final int FIRST_ITEM = 0;
        productPage = homePage.getCategoriesSection().openProductWithName(searchProduct);
        String productName = productPage.getProdcutName();
        softAssert.assertTrue(productName.equalsIgnoreCase(searchProduct));
        productPage.addToCart();
        softAssert.assertTrue(productPage.productAddedToCart());
        productPage.closeAlert();
        cartPage = homePage.getNavBar().navToCart();
        softAssert.assertTrue(searchProduct.equalsIgnoreCase(cartPage.getCartItemName(FIRST_ITEM)));
        softAssert.assertAll();
    }
}
