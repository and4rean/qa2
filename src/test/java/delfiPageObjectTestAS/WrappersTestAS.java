package delfiPageObjectTestAS;

import delfiPageObjectTestAS.Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WrappersTestAS {

    BaseFunctions baseFunc    = new BaseFunctions();
    BaseFunctions baseFuncMOB = new BaseFunctions();

    private static final Logger LOGGER = LogManager.getLogger(WrappersTestAS.class);

    private static final String HOME_PAGE_URL = "http://delfi.lv";
    private static final String MOB_HOME_PAGE_URL = "http://m.delfi.lv";
    //private static final String SEARCH_NAME = "Šveices policija jau vasarā saņēmusi sūdzības par Latvijas pusaudža uzvedību"; //"Riga vs Riga";
    private static final String SEARCH_NAME = "Saūda Arābijā aizturēti"; //"Zatlers Šlesera sacīto"; //"Šveices policija"; //"Riga vs Riga";


    @Test
    public void wrapperTestAS () {

        //LOGGER.info("Open home page");
        baseFunc.goToURL(HOME_PAGE_URL);

        //LOGGER.info("Open MOB home page");
        baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);


// /*
        //LOGGER.info("Getting article title");
        HomePage homePage = new HomePage(baseFunc);
        String title = homePage.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("title AS: "+title);

        //LOGGER.info("Getting article comment count  = IF EXIST! and 0 = means NOT EXIST comment count");
        int count = homePage.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("count AS: "+count);


        //LOGGER.info("Open article");
        ArticlePage articlePage = homePage.openArticleByTitle(SEARCH_NAME); //ArticlePage articlePage = homePage.openArticle();


        //LOGGER.info("Getting sub_article title");
        WebElement subArticle = articlePage.getSUBArticle();
        String subTitle = articlePage.getSUBTitle(subArticle);
        System.out.println("subTitle AS: "+subTitle);

        //LOGGER.info("Getting sub_article comment count");
        int subCount = articlePage.getSUBCommentCount(subArticle);
        System.out.println("subCount AS: "+subCount);

        //LOGGER.info("Comparing title and subTitle");
        Assert.assertEquals("Not Equal title and subTitle Nr=", title, subTitle);

        //LOGGER.info("Comparing comment count and comment subCount = IF EXIST! and 0 = means NOT EXIST comment count");
        //if (count != 0)
        Assert.assertEquals("Not Equal Count and subCount Nr=", count, subCount);

        if (subCount != 0) { //IF EXIST! subCount. If 0 then no subcount exist and impossible to click COMMENT PAGE - AT ALL!!");

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

        } else
            LOGGER.info("//NOT EXIST! subCount!! =0 = and impossible to click and make Assertion with COMMENT PAGE - AT ALL!!");


        //LOGGER.info("Quit driver!");
        baseFunc.quitDriver();
// */



// /*
        //LOGGER.info("MOB Getting article title");
        HomePageMOB homePageMOB = new HomePageMOB(baseFuncMOB);
        String titleMOB = homePageMOB.getArticleTitleNameAS(SEARCH_NAME);
        System.out.println("MOB title AS: "+titleMOB);

        //LOGGER.info("MOB Getting article comment count  = IF EXIST! and 0 = means NOT EXIST comment count");
        int countMOB = homePageMOB.getArticleCommentCountAS(SEARCH_NAME);
        System.out.println("MOB count AS: "+countMOB);


        //LOGGER.info("MOB Open MOB article");
        ArticlePageMOB articlePageMOB = homePageMOB.openArticleByTitle(SEARCH_NAME); //ArticlePage articlePage = homePage.openArticle();


        //LOGGER.info("MOB Getting sub_article title");
        WebElement subArticleMOB = articlePageMOB.getSUBArticle();
        String subTitleMOB = articlePageMOB.getSUBTitle(subArticleMOB);
        System.out.println("MOB subTitle AS: "+subTitleMOB);

        //LOGGER.info("MOB Getting sub_article comment count");
        int subCountMOB = articlePageMOB.getSUBCommentCount(subArticleMOB);
        System.out.println("MOB subCount AS: "+subCountMOB);

        //LOGGER.info("MOB Comparing MOB title and MOB subTitle");
        Assert.assertEquals("MOB Not Equal title and MOB subTitle Nr=", titleMOB, subTitleMOB);

        //LOGGER.info("MOB Comparing comment MOB count and comment MOB subCount = IF EXIST! and 0 = means NOT EXIST comment count");
        //if (count != 0)
        Assert.assertEquals("MOB Not Equal Count and MOB subCount Nr=", countMOB, subCountMOB);

        if (subCountMOB != 0) { //IF EXIST! MOB subCount. If 0 then no MOB subcount exist and impossible to click COMMENT PAGE - AT ALL!!");

            //LOGGER.info("MOB Open comment MOB page");
            CommentPageMOB commentPageMOB = articlePageMOB.openCommentPage();

            //LOGGER.info("MOB Getting MOB comment page title");
            WebElement sub2ArticleMOB = commentPageMOB.getSUB2Article();
            String sub2TitleMOB = commentPageMOB.getSUB2Title(sub2ArticleMOB);
            System.out.println("MOB sub2title AS: "+sub2TitleMOB);

            //LOGGER.info("MOB Getting registered MOB comment count");
            int sub2RegCountMOB = commentPageMOB.getSUB2RegisteredCommentCount(sub2ArticleMOB);

            //LOGGER.info("MOB Getting anonim MOB comment count");
            int sub2AnonCountMOB = commentPageMOB.getSUB2AnonimCommentCount(sub2ArticleMOB);

            //LOGGER.info("MOB Getting sum of MOB  registered and MOB anonim comment count");
            int sub2TotCountMOB = sub2RegCountMOB + sub2AnonCountMOB;
            System.out.println("MOB sub2TotCount AS: "+sub2TotCountMOB);

            //LOGGER.info("Comparing title and sub2Title");
            Assert.assertEquals("MOB Not Equal title and MOB sub2Title Nr=", titleMOB, subTitleMOB);

            //LOGGER.info("Comparing comment count and comment sub2Count");
            Assert.assertEquals("MOB Not Equal Count and MOB sub2Count Nr=", countMOB, sub2TotCountMOB);

        } else
            LOGGER.info("//NOT EXIST! MOB subCount!! =0 = and impossible to click and make Assertion with COMMENT PAGE - AT ALL!!");


        //LOGGER.info("Quit MOB driver!");
        baseFuncMOB.quitDriver();
// */




    }

}
