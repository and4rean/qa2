package delfiTestAS;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.SocketPermission;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * */

public class MainDelfiTest {

    private String driverName = "Chrome";
    private String driverType = "webdriver.chrome.driver";
    private String driverLocation = "C:/chromedriver.exe";
    private String startPage = "http://delfi.lv";   private String mobileStartPage = "http://m.delfi.lv";


    //full version LOCATORS
    private static final By ARTICLES = By.xpath(".//h3[@class='top2012-title']");//By.partialLinkText("Viesuļvētra 'Irma'"); //By.xpath(".//lalal");
    private static final By ARTICLE_TITLES = By.xpath(".//*[@class='top2012-title']");
    private static final By ARTICLE_COUNTS = By.xpath(".//*[@class='comment-count']");

    private static final By SUB_ARTICLE = By.xpath(".//*[@class='article-title']"); //By.partialLinkText("Viesuļvētra 'Irma'"); //By.xpath(".//lalal");
    private static final By SUB_ARTICLE_TITLE = By.xpath(".//*[@itemprop='headline name']");
    private static final By SUB_ARTICLE_COUNT = By.xpath(".//*[@class='comment-count']");

    private static final By SUB2_REG_ARTICLE_COUNT = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']"); //registered comments!
    private static final By SUB2_ANON_ARTICLE_COUNT = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']"); //anonymous comments!


    //mobile version LOCATORS
    private static final By MOB_ARTICLES = By.xpath(".//*[@class='md-mosaic-title']");//By.xpath(".//*[@class='md-scrollpos']");
    private static final By MOB_ARTICLE_TITLES = By.xpath(".//*[@class='md-scrollpos']");
    private static final By MOB_ARTICLE_COUNTS = By.xpath(".//*[@class='commentCount']");

    private static final By MOB_SUB_ARTICLE = By.xpath(".//*[@class='article-title']");
    private static final By MOB_SUB_ARTICLE_TITLE = By.xpath(".//h1");
    private static final By MOB_SUB_ARTICLE_COUNT = By.xpath(".//*[@class='commentCount']");

    private static final By MOB_SUB2_REG_ARTICLE_COUNT  = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']"); //registered comments!
    private static final By MOB_SUB2_ANON_ARTICLE_COUNT = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-anon']"); //anonymous comments!



    @Test
    public void delfiTestAS() throws InterruptedException {

        //Chrome Driver
        System.setProperty(driverType, driverLocation); //System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(startPage);

        WebDriver mobileDriver = new ChromeDriver(); //if (driverName == "Chrome") driver = new ChromeDriver(); else driver = new FirefoxDriver();
        mobileDriver.manage().window().maximize(); //driver.manage().window().fullscreen();
        mobileDriver.get(mobileStartPage); //driver.get("http://javaguru.lv");





        //1. F-U-L-L DELFI VERSION!
        WebDriverWait wait = new WebDriverWait(driver, 6); // wait variable - if we will need to wait for element
        List<WebElement> articleList = driver.findElements(ARTICLES); //List<WebElement> articleList = driver.findElements(By.xpath(".//*[@class='top2012-title']"));//xpath(".//class"));

        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>(); //ArrayList<String> counts = new ArrayList<String>();
        ArrayList<String> hrefIDs = new ArrayList<String>();

        //taking 5 first articles = Dima-boss ordered :) and extracting titleNameText, titleCommentCount, titleLinkHref and adding it to 3 lists
        for (int i=0; i<5; i++) {
            WebElement element = articleList.get(i);

            //extracting article name
            titles.add(element.findElement(ARTICLE_TITLES).getText());

            //extracting comment count
            if (element.findElements(ARTICLE_COUNTS).size() > 0) {
                String countText = element.findElement(ARTICLE_COUNTS).getText(); //must be (101)
                String count = countText.substring(countText.indexOf("(")+1, countText.indexOf(")")); //must be 101
                counts.add(Integer.valueOf(count)); //adding to List converting (str->to Int)
            } else
                counts.add(0);

            //extracting from link href id=123123
            String hrefLink = element.findElement(ARTICLE_TITLES).getAttribute("href");
            //String id = hrefLink.substring(hrefLink.indexOf("id=")+3); //123123
            hrefIDs.add(hrefLink); //we cant use linkPart+id because link part is also different /sport/ or /news/ so we need full links
        }


        //Entering every title and comparing titleText and titleCounts with subTitleText and subTitleCount! (=2nd level)
        //And entering more lower level(comment page) and comparing subSubTitleCommentCount and titleCommentCount
        for (int i=0; i<2 ; i++) {
        //for (int i=0; i<titles.size() ; i++) {
            driver.get(hrefIDs.get(i));
            WebElement element = driver.findElement(SUB_ARTICLE);
            //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(SUB_ARTICLE));
            //driver.close(); //System.out.println(element.getText());

            //extracting article name
            String subTitle = element.findElement(SUB_ARTICLE_TITLE).getText();

            //extracting comment count
            Integer subCount;
            if (element.findElements(SUB_ARTICLE_COUNT).size() > 0) {
                String subCountText = element.findElement(SUB_ARTICLE_COUNT).getText();
                subCount = Integer.valueOf( subCountText.substring(subCountText.indexOf("(")+1, subCountText.indexOf(")")) ); //must be 101

            } else
                subCount = 0;

            //System.out.println(subTitle + " - " + subCount);
            Assert.assertEquals("Not Equal subArticle and Article Nr="+i,titles.get(i),subTitle );
            Assert.assertEquals("Not Equal subCount   and Count   Nr="+i,counts.get(i),subCount );

            //entering comment article (=3rd level) if exist comments
            if (subCount != 0) {
                String subHrefLink = element.findElement(SUB_ARTICLE_COUNT).getAttribute("href");
                driver.get(subHrefLink);

                WebElement regCountElement  = driver.findElement(SUB2_REG_ARTICLE_COUNT);
                WebElement anonCountElement = driver.findElement(SUB2_ANON_ARTICLE_COUNT);

                String regCountText  = regCountElement.findElement(By.xpath(".//span")).getText(); //(101)
                String anonCountText = anonCountElement.findElement(By.xpath(".//span")).getText(); //(101)

                Integer regCount  = Integer.valueOf( regCountText.substring(regCountText.indexOf("(")+1, regCountText.indexOf(")")) );
                Integer anonCount = Integer.valueOf( anonCountText.substring(anonCountText.indexOf("(")+1, anonCountText.indexOf(")")) );
                Integer sum = regCount +anonCount;

                System.out.println(regCount+ " = " +anonCount);
                Assert.assertEquals("Not Equal Count and Sub2_REG+ANON Nr="+i,counts.get(i), sum);

            }

        }






        //2. M-O-B-I-L-E DELFI VERSION!
        WebDriverWait mobWait = new WebDriverWait(mobileDriver, 6); // wait variable - if we will need to wait for element
        List<WebElement> mobArticleList = mobileDriver.findElements(MOB_ARTICLES); //List<WebElement> articleList = driver.findElements(By.xpath(".//*[@class='top2012-title']"));//xpath(".//class"));

        ArrayList<String> mobTitles = new ArrayList<String>();
        ArrayList<Integer> mobCounts = new ArrayList<Integer>(); //ArrayList<String> counts = new ArrayList<String>();
        ArrayList<String> mobHrefIDs = new ArrayList<String>();

        //taking 5 first articles = Dima-boss ordered :) and extracting titleNameText, titleCommentCount, titleLinkHref and adding it to 3 lists
        for (int i=0; i<5; i++) {
            WebElement element = mobArticleList.get(i);

            //extracting article name
            mobTitles.add(element.findElement(MOB_ARTICLE_TITLES).getText());

            //extracting comment count
            if (element.findElements(MOB_ARTICLE_COUNTS).size() > 0) {
                String mobCountText = element.findElement(MOB_ARTICLE_COUNTS).getText(); //must be (101)
                String mobCount = mobCountText.substring(mobCountText.indexOf("(")+1, mobCountText.indexOf(")")); //must be 101
                mobCounts.add(Integer.valueOf(mobCount)); //adding to List converting (str->to Int)
            } else
                mobCounts.add(0);

            //extracting from link href id=123123
            String mobHrefLink = element.findElement(MOB_ARTICLE_TITLES).getAttribute("href");
            //String id = hrefLink.substring(hrefLink.indexOf("id=")+3); //123123
            mobHrefIDs.add(mobHrefLink); //we cant use linkPart+id because link part is also different /sport/ or /news/ so we need full links

        }
        //for (String  mTit : mobTitles)        { System.out.println(mTit + " -index- " + mobTitles.indexOf(mTit)); }
        //for (Integer mCo  : mobCounts)        { System.out.println(mCo + " -index- " + mobCounts.indexOf(mCo)); }
        //for (String mHref  : mobHrefIDs)      { System.out.println(mHref + " -index- " + mobHrefIDs.indexOf(mHref)); }


        //Entering every title and comparing titleText and titleCounts with subTitleText and subTitleCount! (=2nd level)
        //And entering more lower level(comment page) and comparing subSubTitleCommentCount and titleCommentCount
        for (int i=0; i<2 ; i++) {
            //for (int i=0; i<titles.size() ; i++) {
            mobileDriver.get(mobHrefIDs.get(i));
            WebElement element = mobileDriver.findElement(MOB_SUB_ARTICLE);
            //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(SUB_ARTICLE));
            //driver.close(); //System.out.println(element.getText());

            //extracting article name
            String mobSubTitle = element.findElement(MOB_SUB_ARTICLE_TITLE).getText();
            //System.out.println(mobSubTitle);


            //extracting comment count
            Integer mobSubCount;
            if (element.findElements(MOB_SUB_ARTICLE_COUNT).size() > 0) {
                String subCountText = element.findElement(MOB_SUB_ARTICLE_COUNT).getText();
                mobSubCount = Integer.valueOf( subCountText.substring(subCountText.indexOf("(")+1, subCountText.indexOf(")")) ); //must be 101

            } else
                mobSubCount = 0;

            //System.out.println(mobSubTitle + " - " + mobSubCount);
            Assert.assertEquals("Not Equal mobSubArticle and mobArticle Nr="+i,mobTitles.get(i),mobSubTitle );
            Assert.assertEquals("Not Equal mobSubCount   and mobCount   Nr="+i,mobCounts.get(i),mobSubCount );


            //entering comment article (=3rd level) if exist comments
            if (mobSubCount != 0) {
                String mobSubHrefLink = element.findElement(MOB_SUB_ARTICLE_COUNT).getAttribute("href");
                mobileDriver.get(mobSubHrefLink);

                WebElement mobRegCountElement  = mobileDriver.findElement(MOB_SUB2_REG_ARTICLE_COUNT);
                WebElement mobAnonCountElement = mobileDriver.findElement(MOB_SUB2_ANON_ARTICLE_COUNT);

                String mobRegCountText  = mobRegCountElement.findElement(By.xpath(".//span")).getText(); //(101)
                String mobAnonCountText = mobAnonCountElement.findElement(By.xpath(".//span")).getText(); //(101)

                Integer mobRegCount  = Integer.valueOf( mobRegCountText.substring(mobRegCountText.indexOf("(")+1, mobRegCountText.indexOf(")")) );
                Integer mobAnonCount = Integer.valueOf( mobAnonCountText.substring(mobAnonCountText.indexOf("(")+1, mobAnonCountText.indexOf(")")) );
                Integer mobSum = mobRegCount + mobAnonCount;

                System.out.println("mob." +mobRegCount+ " = " +mobAnonCount);
                Assert.assertEquals("Not Equal mobCount and mobSub2_REG+ANON Nr="+i,mobCounts.get(i), mobSum);

            }

        }






        //3. Compare F-U-L-L and M-O-B-I-L-E  titles + counts!
        for (int i=0; i<titles.size(); i++){
            Assert.assertEquals("Not Equal mobTitle and title Nr="+i,titles.get(i), mobTitles.get(i));
            Assert.assertEquals("Not Equal mobCount and count Nr="+i,counts.get(i), mobCounts.get(i));
        }
        /*
        for (String title : titles) {
            Assert.assertEquals("Not Equal mobTitle and title Nr="+titles.indexOf(title),title, mobTitles.get(titles.indexOf(title)));
            Assert.assertEquals("Not Equal mobCount and count Nr="+titles.indexOf(title),counts.get(titles.indexOf(title)), mobCounts.get(titles.indexOf(title)));
        }
        */




            //System.out.println(" -= titles! =- -> " + titles.size()); //for (String tit : titles)        { System.out.println(tit + " -index- " + titles.indexOf(tit)); }
//        System.out.println(" -= counts! =- -> " + counts.size()); //for (Integer cou : counts)        { System.out.println(cou + " -index- " + counts.indexOf(cou)); }
//        for (String href : hrefIDs)        { System.out.println(href + " -index- " + hrefIDs.indexOf(href)); }



        //Thread.sleep(1000);
        driver.quit();
        mobileDriver.quit();
        //ctrl-D or shift-shift or shift-alt=up or down
    }


}
