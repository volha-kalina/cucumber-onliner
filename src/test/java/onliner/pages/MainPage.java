package onliner.pages;

import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public static final By CAPTION = By.xpath("//*[@id=\"container\"]//*[@href = \"https://catalog.onliner.by/\"]");
    public static final String CATEGORY_LINK = "//nav/ul/li/a/span[contains(text(),'CATEGORY_NAME')]";

    public MainPage() {
        super(CAPTION);
    }

    public void navigateTo(String categoryName) {
        new Button(By.xpath(CATEGORY_LINK.replace("CATEGORY_NAME", categoryName))).clickElement();
    }
}
