package onliner.pages;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CataloguePage extends BasePage {
    private static final By CATALOG_TITLE = By.xpath("//h1[@class = \"catalog-navigation__title\" and contains(.,\"Каталог\")]");
    private static final String CATEGORY = "//*[@id=\"container\"]//span[contains(text(),'CATEGORY_NAME')]";
    private static final String SUB_CATEGORY = "//*[@class = \"catalog-navigation-list__aside-title\" and contains(.,\"CATEGORY_NAME\")]";
    private static final String PRODUCT = "//span[@class = \"catalog-navigation-list__dropdown-data\" and contains(.,\"PRODUCT_NAME\")]";


    @FindBy(xpath = "//a[@href = \"https://catalog.onliner.by/tv\"]//span[@class = \"catalog-navigation-list__dropdown-data\" and contains(.,\"Телевизоры\")]")
    private WebElement tvMenu;

    private Actions actions;

    public CataloguePage() {
        super(CATALOG_TITLE);
        actions = new Actions(Browser.getDriver());
    }

    public void selectCategory(String categoryName) {
        baseElement.clickElement(By.xpath(CATEGORY.replace("CATEGORY_NAME", categoryName)));
    }

    public void selectSubCategory(String categoryName) {
        baseElement.clickElement(By.xpath(SUB_CATEGORY.replace("CATEGORY_NAME", categoryName)));
    }

    public void selectProduct(String categoryName) {
        baseElement.clickElement(By.xpath(PRODUCT.replace("PRODUCT_NAME", categoryName)));
    }
}
