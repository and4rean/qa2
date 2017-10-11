package delfiPageObjectTestAS;

import delfiPageObjectTestAS.Pages.*;
import delfiTestAS.MainDelfiTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectTestAS2Cycles {

    BaseFunctions baseFunc = new BaseFunctions();
    BaseFunctions baseFuncMOB = new BaseFunctions();

    private static final Logger LOGGER = LogManager.getLogger(PageObjectTestAS2Cycles.class);
    private static final String HOME_PAGE_URL = "http://delfi.lv";
    private static final String MOB_HOME_PAGE_URL = "http://m.delfi.lv";

    @Test
    public void delfiPageObjectTestAS() {

        //LOGGER.info("Open home page");
        baseFunc.goToURL(HOME_PAGE_URL);

        //LOGGER.info("Open MOB home page");
        baseFuncMOB.goToURL(MOB_HOME_PAGE_URL);

        int start = 1; int stop = 2;

// /*

        //LOGGER.info("Getting CUSTOM articleList and extracting titles and counts");
        HomePage homePage = new HomePage(baseFunc);

        List<WebElement> articleListCustom = homePage.getArticles();
        //List<WebElement> articleListCustom = homePage.getArticlesCustom(1,3);

        System.out.println("size= " + articleListCustom.size());
        for (WebElement art : articleListCustom) {
            System.out.println(art + " =text= " + art.getText() + " -index- " + articleListCustom.indexOf(art));
        }
        System.out.println("AA");

        for (int i = start; i < stop; i++) {
            //for (int i=0; i<articleListCustom.size(); i++) {
            //for (WebElement artCust : articleListCustom) {

            //LOGGER.info("Getting article title");
            String title = homePage.getTitleByID(i);
            //String title = homePage.getTitle(articleListCustom.get(i));
            System.out.println("title AS: " + title + " index- "+i);

            //LOGGER.info("Getting article comment count  = IF EXIST! and 0 = means NOT EXIST comment count");
            int count = homePage.getCommentCountByID(i); //homePage.getCommentCount(artCust);
            //int count = homePage.getCommentCount(articleListCustom.get(i)); //homePage.getCommentCount(artCust);
            System.out.println("count AS: " + count + " index- "+i);


            //LOGGER.info("Open article");
            ArticlePage articlePage = homePage.openArticleByID(i);
            //ArticlePage articlePage = homePage.openArticle();

            //LOGGER.info("Getting sub_article title");
            WebElement subArticle = articlePage.getSUBArticle();
            String subTitle = articlePage.getSUBTitle(subArticle);
            System.out.println("subTitle AS: " + subTitle);

            //LOGGER.info("Getting sub_article comment count");
            int subCount = articlePage.getSUBCommentCount(subArticle);
            System.out.println("subCount AS: " + subCount);


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


            baseFunc.goToURL(HOME_PAGE_URL); //WE MUST RETURN TO HOME PAGE and then to enter next article!!
        }


        //LOGGER.info("Quit driver!");
        baseFunc.quitDriver();
// */








// /*

        //LOGGER.info("Getting CUSTOM MOB articleList and extracting MOB titles and MOB counts");
        HomePageMOB homePageMOB = new HomePageMOB(baseFuncMOB);

        List<WebElement> articleListCustomMOB = homePageMOB.getArticles();
        //List<WebElement> articleListCustomMOB = homePage.getArticlesCustom(1,3);

        System.out.println("sizeMOB= " + articleListCustomMOB.size());
        for (WebElement art : articleListCustomMOB) {
            System.out.println(art + " =textMOB= " + art.getText() + " -indexMOB- " + articleListCustomMOB.indexOf(art));
        }
        System.out.println("AA");

        for (int i = start; i < stop; i++) {
            //for (int i=0; i<articleListCustomMOB.size(); i++) {
            //for (WebElement artCustMOB : articleListCustomMOB) {

            //LOGGER.info("Getting MOB article title");
            String titleMOB = homePageMOB.getTitleByID(i);
            //String title = homePage.getTitle(articleListCustom.get(i));
            System.out.println("MOB title AS: " + titleMOB + " MOB index- "+i);


            //LOGGER.info("Getting MOB article comment count = IF EXIST! and 0 = means NOT EXIST comment count");
            int countMOB = homePageMOB.getCommentCountByID(i); //homePage.getCommentCount(artCust);
            //int countMOB = homePageMOB.getCommentCount(articleMOB);
            System.out.println("MOB count AS: "+countMOB);



            //LOGGER.info("Open MOB article");
            ArticlePageMOB articlePageMOB = homePageMOB.openArticleByID(i);
            //ArticlePageMOB articlePageMOB = homePageMOB.openArticle();

            //LOGGER.info("Getting MOB sub_article title");
            WebElement subArticleMOB = articlePageMOB.getSUBArticle();
            String subTitleMOB = articlePageMOB.getSUBTitle(subArticleMOB);
            System.out.println("MOB subTitle AS: "+subTitleMOB);

            //LOGGER.info("Getting MOB sub_article comment count");
            int subCountMOB = articlePageMOB.getSUBCommentCount(subArticleMOB);
            System.out.println("MOB subCount AS: "+subCountMOB);

            //LOGGER.info("Comparing MOB title and MOB subTitle");
            Assert.assertEquals("Not Equal MOB title and MOB subTitle Nr="+i, titleMOB, subTitleMOB);

            //LOGGER.info("Comparing MOB comment count and MOB comment subCount  = IF EXIST! and 0 = means NOT EXIST comment count");
            //if (countMOB != 0)
            Assert.assertEquals("Not Equal MOB Count and MOB subCount Nr=", countMOB, subCountMOB);


            if (subCountMOB != 0) { //IF EXIST! subCount. If 0 then no subcount exist and impossible to click COMMENT PAGE - AT ALL!!");

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

            } else
                LOGGER.info("//NOT EXIST! MOB subCountMOB!! =0 = and impossible to click and make Assertion with MOB COMMENT PAGE - AT ALL!!");


            baseFuncMOB.goToURL(MOB_HOME_PAGE_URL); //WE MUST RETURN TO HOME PAGE and then to enter next article!!
        }





        //LOGGER.info("Quit MOB driver!");
        baseFuncMOB.quitDriver();

// */



/*
        //LOGGER.info("Comparing title and MOB title");
        Assert.assertEquals("Not Equal title and MOB title Nr=", title, titleMOB);

        //LOGGER.info("Comparing comment count and MOB comment count");
        Assert.assertEquals("Not Equal Count and MOB Count Nr=", count, countMOB);


*/


        LOGGER.info("!!");
        LOGGER.info("!!");
        LOGGER.info("Tests ARE SUCCESSFULL!");


    }
}
