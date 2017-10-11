package delfiPageObjectTestAS.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    BaseFunctions baseFunc;
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    private static final By ARTICLES = By.xpath(".//h3[@class='top2012-title']"); //By.xpath(".//a[@class='top2012-title']"); //By.xpath(".//h3[@class='top2012-title']"); //By.xpath(".//*[@class='top2012-title']");
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
        //LOGGER.info("Getting custom size articleList on homepage");
        List<WebElement> articleList = baseFunc.getElements(ARTICLES);

        return articleList;
    }

    public List<WebElement> getArticlesCustom(int start, int stop) {
        //LOGGER.info("Getting custom size articleList on homepage");
        List<WebElement> articleList = baseFunc.getElements(ARTICLES);
        List<WebElement> articleListCustom = new ArrayList<WebElement>();
        for (int i = start; i < stop; i++) { articleListCustom.add(articleList.get(i)); }

        return articleListCustom;
    }

    public String getTitle(WebElement article) {
        //LOGGER.info("Getting title");
        return baseFunc.getElement(ARTICLE_TITLE).getText();
    }

    public String getTitleByID(int i) {
        //LOGGER.info("Getting title");
        return baseFunc.getElementByID(ARTICLE_TITLE, i).getText();
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

    public int getCommentCountByID(int i) {
        //LOGGER.info("Getting comment count");
        int countReady;
        // if (baseFunc.getElementByID(ARTICLE_TITLE, i).findElements(ARTICLE_COUNT).size() > 0) {
        if (baseFunc.getElements(ARTICLE_COUNT).size() > 0) { //dont need so complicated - because article page contains 1 title and 1 comment :)
            String countText = baseFunc.getElementByID(ARTICLE_COUNT, i).getText(); //must be exmpl. (101)
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

    public ArticlePage openArticleByID(int i) {
        //LOGGER.info("Click title");
        baseFunc.clickElementByID(ARTICLE_TITLE, i);
        return new ArticlePage(baseFunc);
    }



}
