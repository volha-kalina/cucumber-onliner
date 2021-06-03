package onliner.stepDefinitions;

import framework.BaseTest;
import framework.Browser;
import framework.ConfProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import onliner.pages.CataloguePage;
import onliner.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pages.TvPage;

public class NavigateToCatalogueSteps extends BaseTest {
    public static MainPage mainPage = null;
    public static Browser browser = null;
    protected static ConfProperties config = new ConfProperties();

    @Before
    public void openBrowser() {
        browser = Browser.getInstance();
    }

    @Given("I am on the Onliner main page")
    public void i_am_on_the_onliner_main_page() {
        Browser.openUrl(config.getProperty("mainPage"));
    }

    @When("I navigate to {string}")
    public void i_navigate_to(String string) {
        new MainPage().navigateTo(string);
    }

    @And("I select category {string}")
    public void i_select_category(String string) {
        new CataloguePage().selectCategory(string);
    }

    @And("I select subcategory {string}")
    public void i_select_subcategory(String string) {
        new CataloguePage().selectSubCategory(string);
    }

    @And("I select product {string}")
    public void i_select_product(String string) {
        new CataloguePage().selectProduct(string);
    }

    @And("I set {string} filter")
    public void i_set_filter(String value) {
        new TvPage().menu.findAndClickFilterByName(value);
    }

    @And("I set to {string} range filter values {string} {string}")
    public void i_set_range_filter(String filterName, String filterFrom, String filterTo) {
        if (filterName.contains("цена")) {
            new TvPage().menu.enterPrices(filterFrom, filterTo);
        }
        if (filterName.contains("диагональ")) {
            new TvPage().menu.enterDiagonals(filterFrom, filterTo);
        }
    }

    @Then("I check search results contains needed filters values {string} {string} {string} {string} {string} {string}")
    public void i_check_filters(String manufacturer, String resolution, String priceFrom, String priceTo, String diagonalFrom, String diagonalTo) {
        new TvPage().checkResultTvs(
                manufacturer,
                resolution,
                priceFrom,
                priceTo,
                diagonalFrom,
                diagonalTo
        );
    }

    @After
    public void closeBrowser() {
        Browser.closeBrowser();
    }
}