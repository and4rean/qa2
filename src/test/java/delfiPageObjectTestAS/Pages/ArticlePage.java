package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(ArticlePage.class);

    private static final By SUB_ARTICLE = By.xpath(".//*[@class='article-title']"); //By.partialLinkText("Viesuļvētra 'Irma'"); //By.xpath(".//lalal");
    private static final By SUB_ARTICLE_TITLE = By.xpath(".//*[@itemprop='headline name']");
    private static final By SUB_ARTICLE_COUNT = By.xpath(".//*[@class='comment-count']");

    public ArticlePage(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }


    public WebElement getSUBArticle() {
        //LOGGER.info("Getting subArticle");
        return baseFunc.getElement(SUB_ARTICLE);
    }

    public String getSUBTitle(WebElement article) {
        //LOGGER.info("Getting subTitle");
        return baseFunc.getElement(SUB_ARTICLE_TITLE).getText();
    }

    public int getSUBCommentCount(WebElement article) {
        //LOGGER.info("Getting subComment count");
        String countText = baseFunc.getElement(SUB_ARTICLE_COUNT).getText();
        String count = countText.substring(countText.indexOf("(") + 1, countText.indexOf(")"));
        return Integer.valueOf(count);
    }


    public CommentPage openCommentPage() {
        //LOGGER.info("Click title");
        baseFunc.clickElement(SUB_ARTICLE_COUNT);
        return new CommentPage(baseFunc);
    }


}
