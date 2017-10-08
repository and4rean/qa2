package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePage {
    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(ArticlePage.class);

    private static final By SUB_ARTICLES = By.xpath(".//h3[@class='top2012-title']");
    private static final By SUB_ARTICLE_TITLE = By.xpath(".//*[@class='top2012-title']");
    private static final By SUB_ARTICLE_COUNT = By.xpath(".//*[@class='comment-count']");


    public ArticlePage(BaseFunctions bs) {
        this.baseFunc = bs; //"this" to use variable from (line 10) NOT CREATING NEW ONE!
    }



}
