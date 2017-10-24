package delfiPageObjectTestAS.Wrappers;

import delfiPageObjectTestAS.Pages.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticleWrapper {

    private final BaseFunctions baseFunc;
    private final WebElement element;

    private static final By ARTICLE_TITLE = By.xpath(".//a[@class='top2012-title']"); //By.xpath(".//h3/a");
    private static final By ARTICLE_COUNT = By.xpath(".//a[@class='comment-count']");


    public ArticleWrapper(BaseFunctions baseFunc, WebElement element) {
        this.baseFunc = baseFunc;
        this.element = element;
    }

    public String getArticleTitle() {
        return !element.findElements(ARTICLE_TITLE).isEmpty() ? element.findElement(ARTICLE_TITLE).getText() : null;
    }


// /*
    public int getArticleCommentCount() {
        int countReady;
        if (element.findElements(ARTICLE_COUNT).size() > 0 ) {
            String countText = element.findElement(ARTICLE_COUNT).getText(); //must be exmpl. (101)
            String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")")); //must be exmpl. 101
            countReady = Integer.valueOf(count);
        } else
            countReady = 0;

        return countReady;
    }
// */


    public void clickOnTitle() {
        element.click();
    }
}
