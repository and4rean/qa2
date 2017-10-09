package delfiPageObjectTestAS;

import delfiPageObjectTestAS.Pages.ArticlePage;
import delfiPageObjectTestAS.Pages.BaseFunctions;
import delfiPageObjectTestAS.Pages.HomePage;
import delfiTestAS.MainDelfiTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class PageObjectTestAS {

    BaseFunctions baseFunc = new BaseFunctions();
    private static final Logger LOGGER = LogManager.getLogger(PageObjectTestAS.class);
    private static final String HOME_PAGE_URL = "http://delfi.lv";

    @Test
    void delfiPageObjectTestAS() {
        LOGGER.info("Open home page");
        baseFunc.goToURL("");

        LOGGER.info("Getting fist article title");
        HomePage homePage = new HomePage(baseFunc);
        WebElement article = homePage.getFirstArticle();
        String title = homePage.getTitle(article);

        LOGGER.info("Getting fist article comment count");
        int count = homePage.getCommentCount(article);

        LOGGER.info("Open fist article");
        ArticlePage articlePage = homePage.openArticle();

        LOGGER.info("Getting article title");

        LOGGER.info("Getting article comment count");
        LOGGER.info("Comparing title");
        LOGGER.info("Comparing comment count");


        LOGGER.info("Open comment page");
        LOGGER.info("Getting comment page title");
        LOGGER.info("Getting registered comment count");
        LOGGER.info("Getting anonim comment count");
        LOGGER.info("Getting sum of registered and anonim comment count");
        LOGGER.info("Comparing title");
        LOGGER.info("Comparing comment count");

        LOGGER.info("Test is successfull");


    }
}
