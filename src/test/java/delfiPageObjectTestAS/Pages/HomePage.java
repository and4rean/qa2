package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    private static final By ARTICLES = By.xpath(".//h3[@class='top2012-title']");
    private static final By ARTICLE_TITLE = By.xpath(".//a[@class='top2012-title']"); //By.xpath(".//h3/a");
    private static final By ARTICLE_COUNT = By.xpath(".//a[@class='comment-count']");



    public HomePage(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }

    public WebElement getArticle() {
        //LOGGER.info("Getting article on homepage");
        return baseFunc.getElement(ARTICLES);
    }

    public List<WebElement> getArticles() {
        //LOGGER.info("Getting article on homepage");
        return baseFunc.getElements(ARTICLES);
    }

    public String getTitle(WebElement article) {
        //LOGGER.info("Getting title");
        return baseFunc.getElement(ARTICLE_TITLE).getText();
    }

    public int getCommentCount(WebElement article) {
        //LOGGER.info("Getting comment count");
        int countReady;
        if (baseFunc.getElements(ARTICLE_COUNT).size() > 0) {
            String countText = baseFunc.getElement(ARTICLE_COUNT).getText(); //must be exmpl. (101)
            String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")")); //must be exmpl. 101
            countReady = Integer.valueOf(count);
        } else
            countReady = 0;

        return countReady;
    }

    public ArticlePage openArticle() {
        //LOGGER.info("Click title");
        baseFunc.clickElement(ARTICLE_TITLE);
        return new ArticlePage(baseFunc);
    }



}
