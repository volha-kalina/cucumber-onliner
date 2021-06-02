package onliner.pages;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TvPage extends BasePage {
    private static final By tvPageTitle = By.xpath("//h1[@class = \"schema-header__title\" and contains(.,\"Телевизоры\")]");
    private static final By firstTitle = By.xpath("//*[@class=\"schema-product__title\"]//a/span");
    private static final By firstFilter = By.xpath("//*[@class=\"schema-tags__item\"]");
    private static final By tvs = By.cssSelector("div.schema-product__group > div.schema-product");
    private static final By tvTitle = By.cssSelector("div.schema-product__title>a>span");
    private static final By tvDesc = By.cssSelector(".schema-product__description > span");
    private static final By tvPrice = By.cssSelector("a.schema-product__price-value > span");

    public CatalogMenu menu;

    public TvPage() {
        super(tvPageTitle);
        this.menu = new CatalogMenu(Browser.getDriver());
    }

    public void checkResultTvs(
            String manufacturer,
            String resolution,
            String priceFrom,
            String priceTo,
            String diagonalFrom,
            String diagonalTo
    ) {
        (new WebDriverWait(Browser.getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                Boolean isManufacturerFilterSelected = Browser.getDriver().findElements(firstFilter).get(0).getText().contains(manufacturer);
                Boolean isFirstElementCorrect = Browser.getDriver().findElement(firstTitle).getText().contains(manufacturer);

                if (isManufacturerFilterSelected == true && isFirstElementCorrect == true) {
                    return true;
                }

                return false;
            }
        });


        List<WebElement> Tvs = Browser.getDriver().findElements(tvs);

        for (int i = 0; i < Tvs.size(); i++) {
            WebElement currentTv = Tvs.get(i);
            WebElement tvTitle = currentTv.findElement(this.tvTitle);
            WebElement tvDescription = currentTv.findElement(tvDesc);
            Double price = Double.parseDouble(
                    currentTv.findElement(tvPrice).getText()
                            .replace(" р.", "")
                            .replace(",", ".")
            );
            Integer diagonal = Integer.parseInt(tvDescription.getText().substring(0, 2));

            Assert.assertTrue(tvTitle.getText().contains(manufacturer));
            Assert.assertTrue(tvDescription.getText().contains(resolution));
            Assert.assertTrue(Double.parseDouble(priceFrom) <= price && price < Double.parseDouble(priceTo));
            Assert.assertTrue(Integer.parseInt(diagonalFrom) < diagonal && diagonal < Integer.parseInt(diagonalTo));
        }
    }
}
