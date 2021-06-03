package onliner.pages;

import framework.elements.BaseElement;
import org.openqa.selenium.By;

public class CataloguePage extends BasePage {
    private static final By CATALOG_TITLE = By.xpath("//h1[@class = \"catalog-navigation__title\" and contains(.,\"Каталог\")]");
    private static final String CATEGORY = "//*[@id=\"container\"]//span[contains(text(),'CATEGORY_NAME')]";
    private static final String SUB_CATEGORY = "//*[@class = \"catalog-navigation-list__aside-title\" and contains(.,\"CATEGORY_NAME\")]";
    private static final String PRODUCT = "//span[@class = \"catalog-navigation-list__dropdown-data\" and contains(.,\"PRODUCT_NAME\")]";

    public CataloguePage() {
        super(CATALOG_TITLE);
    }

    public void selectCategory(String categoryName) {
        new BaseElement(By.xpath(CATEGORY.replace("CATEGORY_NAME", categoryName))).clickElement();
    }

    public void selectSubCategory(String categoryName) {
        new BaseElement(By.xpath(SUB_CATEGORY.replace("CATEGORY_NAME", categoryName))).clickElement();
    }

    public void selectProduct(String categoryName) {
        new BaseElement(By.xpath(PRODUCT.replace("PRODUCT_NAME", categoryName))).clickElement();
    }
}
