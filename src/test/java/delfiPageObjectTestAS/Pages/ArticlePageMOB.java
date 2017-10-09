package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageMOB {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(ArticlePageMOB.class);

    private static final By MOB_SUB_ARTICLE = By.xpath(".//*[@class='article-title']");
    private static final By MOB_SUB_ARTICLE_TITLE = By.xpath(".//h1");
    private static final By MOB_SUB_ARTICLE_COUNT = By.xpath(".//*[@class='commentCount']");

    public ArticlePageMOB(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }


    public WebElement getSUBArticle() {
        //LOGGER.info("Getting MOB subArticle");
        return baseFunc.getElement(MOB_SUB_ARTICLE);
    }

    public String getSUBTitle(WebElement article) {
        //LOGGER.info("Getting MOB subTitle");
        return baseFunc.getElement(MOB_SUB_ARTICLE_TITLE).getText();
    }

    public int getSUBCommentCount(WebElement article) {
        //LOGGER.info("Getting MOB subComment count");
        String countText = baseFunc.getElement(MOB_SUB_ARTICLE_COUNT).getText();
        String count = countText.substring(countText.indexOf("(") + 1, countText.indexOf(")"));
        return Integer.valueOf(count);
    }


    public CommentPageMOB openCommentPage() {
        //LOGGER.info("Click MOB title");
        baseFunc.clickElement(MOB_SUB_ARTICLE_COUNT);
        return new CommentPageMOB(baseFunc);
    }


}
