package delfiPageObjectTestAS.Wrappers;

import delfiPageObjectTestAS.Pages.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticleWrapper {

    private final BaseFunctions baseFunc;
    private final WebElement element;

    private static final By TITLE = By.xpath(" locator for TITLE");


    public ArticleWrapper(BaseFunctions baseFunc, WebElement element) {
        this.baseFunc = baseFunc;
        this.element = element;
    }

    public String getArticleTitle() {
        return element.findElements(TITLE).isEmpty() ? element.findElement(TITLE).getText() :null;
    }

    public void clickOnTitle() {
        element.click();
    }
}
