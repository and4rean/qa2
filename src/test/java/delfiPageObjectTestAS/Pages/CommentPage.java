package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommentPage {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(CommentPage.class);

    private static final By SUB2_ARTICLE = By.xpath(".//h1[@class='comments-about-title-h1']");
    private static final By SUB2_ARTICLE_TITLE = By.xpath(".//a[@class='comment-main-title-link']");

    private static final By SUB2_REG_ARTICLE_COUNT = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']"); //registered comments!
    private static final By SUB2_ANON_ARTICLE_COUNT = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']"); //anonymous comments!

    public CommentPage(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }

    public WebElement getSUB2Article() {
        //LOGGER.info("Getting sub2Article");
        return baseFunc.getElement(SUB2_ARTICLE);
    }

    public String getSUB2Title(WebElement article) {
        //LOGGER.info("Getting sub2Title");
        return baseFunc.getElement(SUB2_ARTICLE_TITLE).getText();
    }

    public int getSUB2RegisteredCommentCount(WebElement article) {
        //LOGGER.info("Getting registered sub2Comment count");
        String countText = baseFunc.getElement(SUB2_REG_ARTICLE_COUNT).getText();
        String count = countText.substring(countText.indexOf("(") + 1, countText.indexOf(")"));
        return Integer.valueOf(count);
    }

    public int getSUB2AnonimCommentCount(WebElement article) {
        //LOGGER.info("Getting anonimous sub2Comment count");
        String countText = baseFunc.getElement(SUB2_ANON_ARTICLE_COUNT).getText();
        String count = countText.substring(countText.indexOf("(") + 1, countText.indexOf(")"));
        return Integer.valueOf(count);
    }

}
