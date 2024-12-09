package objects.page;

import objects.product.CategoriesList;
import objects.product.CategoriesSection;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

    private String url = "https://www.demoblaze.com/index.html";
    private CategoriesList categoriesList;
    private CategoriesSection categoriesSection;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        categoriesList = new CategoriesList(webDriver);
        categoriesSection = new CategoriesSection(webDriver);
    }

    @Override
    public String getUrl() {
        return url;
    }

    public CategoriesList getCategoriesList() {
        return categoriesList;
    }

    public CategoriesSection getCategoriesSection() {
        return categoriesSection;
    }
}
