package onliner.pages;

import framework.elements.BaseElement;
import org.openqa.selenium.By;

public class BasePage {

    protected BaseElement baseElement;

    BasePage(By elementLocator) {
        baseElement= new BaseElement(elementLocator);
    }
}
