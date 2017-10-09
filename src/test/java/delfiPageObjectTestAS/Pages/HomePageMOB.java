package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageMOB {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(HomePageMOB.class);

    private static final By MOB_ARTICLES = By.xpath(".//div[@class='md-mosaic-title']"); //By.xpath(".//*[@class='md-scrollpos']");
    private static final By MOB_ARTICLE_TITLE = By.xpath(".//a[@class='md-scrollpos']");
    private static final By MOB_ARTICLE_COUNT = By.xpath(".//a[@class='commentCount']");


    public HomePageMOB(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }

    public WebElement getArticle() {
        //LOGGER.info("Getting MOB article on homepage");
        return baseFunc.getElement(MOB_ARTICLES);
    }

    public String getTitle(WebElement article) {
        //LOGGER.info("Getting MOB title");
        return baseFunc.getElement(MOB_ARTICLE_TITLE).getText();
    }

    public int getCommentCount(WebElement article) {
        //LOGGER.info("Getting MOB comment count");
        String countText = baseFunc.getElement(MOB_ARTICLE_COUNT).getText();
        String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")"));
        return Integer.valueOf(count);
    }

    public ArticlePageMOB openArticle() {
        //LOGGER.info("Click MOB title");
        baseFunc.clickElement(MOB_ARTICLE_TITLE);
        return new ArticlePageMOB(baseFunc);
    }



}
