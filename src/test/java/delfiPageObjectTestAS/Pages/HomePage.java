package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    private static final By ARTICLES = By.xpath(".//h3[@class='top2012-title']");
    private static final By ARTICLE_TITLE = By.xpath(".//*[@class='top2012-title']");
    private static final By ARTICLE_COUNT = By.xpath(".//*[@class='comment-count']");



    public HomePage(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }

    public WebElement getFirstArticle() {
        LOGGER.info("Getting first article on homepage");
        return baseFunc.getElement(ARTICLES);
    }

    public String getTitle(WebElement article) {
        LOGGER.info("Getting title");
        return baseFunc.getElement(ARTICLE_TITLE).getText();
    }

    public int getCommentCount(WebElement article) {
        LOGGER.info("Getting comment count");
        String countText = baseFunc.getElement(ARTICLE_COUNT).getText();
        String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")"));
        return Integer.valueOf(count);
    }

    public ArticlePage openArticle() {
        LOGGER.info("Click title");
        baseFunc.clickElement(ARTICLE_TITLE);
        return new ArticlePage(baseFunc);
    }



}
