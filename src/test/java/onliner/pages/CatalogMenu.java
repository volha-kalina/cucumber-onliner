package onliner.pages;

import framework.elements.BaseElement;
import framework.elements.CheckBox;
import framework.elements.Input;
import framework.elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CatalogMenu {
    private WebDriver driver;
    private Actions actions;

    private static Input priceFromFilter = new Input(By.xpath("//*[@class = \"schema-filter-control__item schema-filter__number-input schema-filter__number-input_price\" and @placeholder= \"от\"]"));
    private static Input priceToFilter = new Input(By.xpath("//div[@class = \"schema-filter-control schema-filter-control_input\"][2]/input[@class = \"schema-filter-control__item schema-filter__number-input schema-filter__number-input_price\"]"));
    private static Select diagonalFrom = new Select(By.xpath("//div[@class = \"schema-filter-control schema-filter-control_select\"][1]/select[@class = \"schema-filter-control__item\"]"));
    private static Select diagonalTo = new Select(By.xpath("//div[@class = \"schema-filter-control schema-filter-control_select\"][2]/select[@class = \"schema-filter-control__item\"]"));
    private static String filterXpath = "//*[@class=\"schema-filter__checkbox-text\" and contains(.,'FILTER_NAME')]";

    public CatalogMenu(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public BaseElement getFilterWebElementByName(String filterName) {
        return new BaseElement(By.xpath(filterXpath.replace("FILTER_NAME", filterName)));
    }

    public void findAndClickFilterByName(String name) {
        BaseElement filter = this.getFilterWebElementByName(name);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filter.getBaseWebElement());
        filter.clickElement();
    }

    public void enterPrices(String priceFrom, String priceTo) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", priceFromFilter.getBaseWebElement());
        priceFromFilter.clickElement();
        priceFromFilter.sendKeys(priceFrom);
        priceToFilter.clickElement();
        priceToFilter.sendKeys(priceTo);
    }

    public void enterDiagonals(String diagonalFrom, String diagonalTo) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.diagonalFrom.getBaseWebElement());
        this.diagonalFrom.sendKeys(diagonalFrom);
        this.diagonalTo.sendKeys(diagonalTo);
    }
}
