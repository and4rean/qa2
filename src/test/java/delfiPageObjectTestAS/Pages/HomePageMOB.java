package delfiPageObjectTestAS.Pages;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import delfiPageObjectTestAS.Wrappers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Optional;
import java.util.stream.Collectors;

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

    public List<WebElement> getArticles() {
        //LOGGER.info("Getting custom size articleList on homepage");
        List<WebElement> articleList = baseFunc.getElements(MOB_ARTICLES);

        return articleList;
    }

    public List<WebElement> getArticlesCustom(int start, int stop) {
        //LOGGER.info("Getting custom size articleList on homepage");
        List<WebElement> articleList = baseFunc.getElements(MOB_ARTICLES);
        List<WebElement> articleListCustom = new ArrayList<WebElement>();
        for (int i = start; i < stop; i++) { articleListCustom.add(articleList.get(i)); }

        return articleListCustom;
    }


    public String getTitle(WebElement article) {
        //LOGGER.info("Getting MOB title");
        return baseFunc.getElement(MOB_ARTICLE_TITLE).getText();
    }

    public String getTitleByID(int i) {
        //LOGGER.info("Getting title");
        return baseFunc.getElementByID(MOB_ARTICLE_TITLE, i).getText();
    }

    public int getCommentCount(WebElement article) {
        //LOGGER.info("Getting MOB comment count");
        int countReady;
        if (baseFunc.getElements(MOB_ARTICLE_COUNT).size() > 0) {
            String countText = baseFunc.getElement(MOB_ARTICLE_COUNT).getText(); //must be exmpl. (101)
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
        if (baseFunc.getElements(MOB_ARTICLE_COUNT).size() > 0) { //dont need so complicated - because article page contains 1 title and 1 comment :)
            String countText = baseFunc.getElementByID(MOB_ARTICLE_COUNT, i).getText(); //must be exmpl. (101)
            String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")")); //must be exmpl. 101
            countReady = Integer.valueOf(count);
        } else
            countReady = 0;

        return countReady;
    }

    public ArticlePageMOB openArticle() {
        //LOGGER.info("Click MOB title");
        baseFunc.clickElement(MOB_ARTICLE_TITLE);
        return new ArticlePageMOB(baseFunc);
    }

    public ArticlePageMOB openArticleByID(int i) {
        //LOGGER.info("Click MOB title");
        baseFunc.clickElementByID(MOB_ARTICLE_TITLE, i);
        return new ArticlePageMOB(baseFunc);
    }

    private List<ArticleWrapperMOB> getAllArticles() {
        List<WebElement> articlesMOB = baseFunc.getElements(MOB_ARTICLES);
        List<ArticleWrapperMOB> articleWrappersMOB = new ArrayList<>();

        Iterables.addAll(articleWrappersMOB,
                articlesMOB.stream()
                        .map(webElement -> new ArticleWrapperMOB(baseFunc, webElement))
                        .collect(Collectors.toList()));
        return articleWrappersMOB;
    }

    private ArticleWrapperMOB getArticleByTitle(String searchName) { // private == because we use it only locally here in this class
        Optional<ArticleWrapperMOB> wrapperMOB = Iterables.tryFind(getAllArticles(),
                articleWrapperMOB -> articleWrapperMOB.getArticleTitle().contains(searchName)); //name.equals(articleWrapper.getArticleTitle())); // articleWrapper -> articleWrapper.getArticleTitle().contains(name));
        return wrapperMOB.isPresent() ? wrapperMOB.get() : null;
    }


    public String getArticleTitleNameAS(String searchName) {
        //LOGGER.info("Get Article Title Name");
        ArticleWrapperMOB artWrapMOB = getArticleByTitle(searchName);

        return artWrapMOB.getArticleTitle();
    }

    public int getArticleCommentCountAS(String searchName) {
        //LOGGER.info("Get Article Comment Count");
        ArticleWrapperMOB artWrapMOB = getArticleByTitle(searchName);

        return artWrapMOB.getArticleCommentCount();
    }


    public ArticlePageMOB openArticleByTitle(String searchName) {
        //LOGGER.info("Open Article By Title");
        ArticleWrapperMOB artWrapMOB = getArticleByTitle(searchName);
        artWrapMOB.clickOnTitle();

        return new ArticlePageMOB(baseFunc);
    }



}
