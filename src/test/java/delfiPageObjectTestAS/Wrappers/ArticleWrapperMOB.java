package delfiPageObjectTestAS.Wrappers;

import delfiPageObjectTestAS.Pages.BaseFunctions;
import delfiPageObjectTestAS.Pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticleWrapperMOB {

    private final BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(ArticleWrapperMOB.class);

    private final WebElement element;

    private static final By MOB_ARTICLE_TITLE = By.xpath(".//a[@class='md-scrollpos']");
    private static final By MOB_ARTICLE_COUNT = By.xpath(".//a[@class='commentCount']");


    public ArticleWrapperMOB(BaseFunctions baseFunc, WebElement element) {
        this.baseFunc = baseFunc;
        this.element = element;
    }

    public String getArticleTitle() {
        //LOGGER.info("Get Article Title MOB");
        return !element.findElements(MOB_ARTICLE_TITLE).isEmpty() ? element.findElement(MOB_ARTICLE_TITLE).getText() : null;
    }


// /*
    public int getArticleCommentCount() {
        //LOGGER.info("Get Article Comment Count MOB");
        int countReady;
        if (element.findElements(MOB_ARTICLE_COUNT).size() > 0 ) {
            String countText = element.findElement(MOB_ARTICLE_COUNT).getText(); //must be exmpl. (101)
            String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")")); //must be exmpl. 101
            countReady = Integer.valueOf(count);
        } else
            countReady = 0;

        return countReady;
    }
// */


    public void clickOnTitle() {
        //LOGGER.info("Click on Title MOB ");
        element.click();
    }

}
