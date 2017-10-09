package delfiPageObjectTestAS;

import delfiPageObjectTestAS.Pages.*;
import delfiTestAS.MainDelfiTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class PageObjectTestAS {

    //BaseFunctions baseFunc = new BaseFunctions();
    BaseFunctions baseFuncMOB = new BaseFunctions();

    private static final Logger LOGGER = LogManager.getLogger(PageObjectTestAS.class);
    private static final String HOME_PAGE_URL = "http://delfi.lv";
    private static final String MOB_HOME_PAGE_URL = "http://m.delfi.lv";

    @Test
    public void delfiPageObjectTestAS() {


/*
        //LOGGER.info("Open home page");
        baseFunc.goToURL(HOME_PAGE_URL);

        //LOGGER.info("Getting article title");
        HomePage homePage = new HomePage(baseFunc);
        WebElement article = homePage.getArticle();
        String title = homePage.getTitle(article);
        System.out.println("title AS: "+title);

        //LOGGER.info("Getting article comment count");
        int count = homePage.getCommentCount(article);
        System.out.println("count AS: "+count);



        //LOGGER.info("Open article");
        ArticlePage articlePage = homePage.openArticle();

        //LOGGER.info("Getting sub_article title");
        WebElement subArticle = articlePage.getSUBArticle();
        String subTitle = articlePage.getSUBTitle(subArticle);
        System.out.println("subTitle AS: "+subTitle);

        //LOGGER.info("Getting sub_article comment count");
        int subCount = articlePage.getSUBCommentCount(subArticle);
        System.out.println("subCount AS: "+subCount);

        //LOGGER.info("Comparing title and subTitle");
        Assert.assertEquals("Not Equal title and subTitle Nr=", title, subTitle);

        //LOGGER.info("Comparing comment count and comment subCount");
        Assert.assertEquals("Not Equal Count and subCount Nr=", count, subCount);



        //LOGGER.info("Open comment page");
        CommentPage commentPage = articlePage.openCommentPage();

        //LOGGER.info("Getting comment page title");
        WebElement sub2Article = commentPage.getSUB2Article();
        String sub2Title = commentPage.getSUB2Title(sub2Article);
        System.out.println("sub2title AS: "+sub2Title);

        //LOGGER.info("Getting registered comment count");
        int sub2RegCount = commentPage.getSUB2RegisteredCommentCount(sub2Article);

        //LOGGER.info("Getting anonim comment count");
        int sub2AnonCount = commentPage.getSUB2AnonimCommentCount(sub2Article);

        //LOGGER.info("Getting sum of registered and anonim comment count");
        int sub2TotCount = sub2RegCount + sub2AnonCount;
        System.out.println("sub2TotCount AS: "+sub2TotCount);

        //LOGGER.info("Comparing title and sub2Title");
        Assert.assertEquals("Not Equal title and sub2Title Nr=", title, subTitle);

        //LOGGER.info("Comparing comment count and comment sub2Count");
        Assert.assertEquals("Not Equal Count and sub2Count Nr=", count, sub2TotCount);
*/






        //LOGGER.info("Open MOB home page");
        baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);

        //LOGGER.info("Getting MOB article title");
        HomePageMOB homePageMOB = new HomePageMOB(baseFuncMOB);
        WebElement articleMOB = homePageMOB.getArticle();
        String titleMOB = homePageMOB.getTitle(articleMOB);
        System.out.println("MOB title AS: "+titleMOB);

        //LOGGER.info("Getting MOB article comment count");
        int countMOB = homePageMOB.getCommentCount(articleMOB);
        System.out.println("MOB count AS: "+countMOB);



        //LOGGER.info("Open MOB article");
        ArticlePageMOB articlePageMOB = homePageMOB.openArticle();

        //LOGGER.info("Getting MOB sub_article title");
        WebElement subArticleMOB = articlePageMOB.getSUBArticle();
        String subTitleMOB = articlePageMOB.getSUBTitle(subArticleMOB);
        System.out.println("MOB subTitle AS: "+subTitleMOB);

        //LOGGER.info("Getting MOB sub_article comment count");
        int subCountMOB = articlePageMOB.getSUBCommentCount(subArticleMOB);
        System.out.println("MOB subCount AS: "+subCountMOB);

        //LOGGER.info("Comparing MOB title and MOB subTitle");
        Assert.assertEquals("Not Equal MOB title and MOB subTitle Nr=", titleMOB, subTitleMOB);

        //LOGGER.info("Comparing MOB comment count and MOB comment subCount");
        Assert.assertEquals("Not Equal MOB Count and MOB subCount Nr=", countMOB, subCountMOB);



        //LOGGER.info("Open MOB comment page");
        CommentPageMOB commentPageMOB = articlePageMOB.openCommentPage();

        //LOGGER.info("Getting MOB comment page title");
        WebElement sub2ArticleMOB = commentPageMOB.getSUB2Article();
        String sub2TitleMOB = commentPageMOB.getSUB2Title(sub2ArticleMOB);
        System.out.println("MOB sub2title AS: "+sub2TitleMOB);

        //LOGGER.info("Getting MOB registered comment count");
        int sub2RegCountMOB = commentPageMOB.getSUB2RegisteredCommentCount(sub2ArticleMOB);

        //LOGGER.info("Getting MOB anonim comment count");
        int sub2AnonCountMOB = commentPageMOB.getSUB2AnonimCommentCount(sub2ArticleMOB);

        //LOGGER.info("Getting sum of MOB registered and MOB anonim comment count");
        int sub2TotCountMOB = sub2RegCountMOB + sub2AnonCountMOB;
        System.out.println("MOB sub2TotCount AS: "+sub2TotCountMOB);

        //LOGGER.info("Comparing MOB title and MOB sub2Title");
        Assert.assertEquals("Not Equal MOB title and MOB sub2Title Nr=", titleMOB, subTitleMOB);

        //LOGGER.info("Comparing MOB comment count and MOB comment sub2Count");
        Assert.assertEquals("Not Equal MOB Count and MOB sub2Count Nr=", countMOB, sub2TotCountMOB);



/*
        //LOGGER.info("Comparing title and MOB title");
        Assert.assertEquals("Not Equal title and MOB title Nr=", title, titleMOB);

        //LOGGER.info("Comparing comment count and MOB comment count");
        Assert.assertEquals("Not Equal Count and MOB Count Nr=", count, countMOB);
*/





        //LOGGER.info("Test is successfull");


    }
}
