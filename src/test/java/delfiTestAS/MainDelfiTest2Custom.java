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

public class MainDelfiTest2Custom {

    private String searchTitleName = "Vesela krava sadauzītu";//"Piektās kategorijas viesuļvētra";//"Lietuvieši cīnīsies par atbalstu";//"LOSP aicina sienu"; //"Lietuvieši cīnīsies par atbalstu";///"LOSP aicina sienu un salmus ruļļos nepārdot ārpus Latvijas (9)";

    private String driverName = "Chrome";
    private String driverType = "webdriver.chrome.driver";
    private String driverLocation = "C:/chromedriver.exe";
    private String startPage = "http://delfi.lv";
    private String mobileStartPage = "http://m.delfi.lv";


    //full version LOCATORS
    private static final By ARTICLES = By.xpath(".//h3[@class='top2012-title']");//By.className("top2012-title");//By.partialLinkText("Viesuļvētra 'Irma'"); //By.xpath(".//lalal");
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

    private static final By MOB_SUB2_REG_ARTICLE_COUNT = By.xpath(".//*[@class='comment-thread-switcher-list-a comment-thread-switcher-list-a-reg']"); //registered comments!
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

        //will use List like a string -- taking 1st (0-index) == reason (for not to edit too much from previous written class) :)
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>(); //ArrayList<String> counts = new ArrayList<String>();
        ArrayList<String> hrefIDs = new ArrayList<String>();


        int foundIndex = -1;
        String foundFullTitleName = new String();
        boolean breakLoop = false;

        //taking 5 first articles = Dima-boss ordered :) and extracting titleNameText, titleCommentCount, titleLinkHref and adding it to 3 lists
        //while (!breakLoop) //breakLoop = true; //if (i == articleList.size() - 1) breakLoop = true;

        for (int i = 0; i < articleList.size(); i++) {
            WebElement element = articleList.get(i);

            String title = element.findElement(ARTICLE_TITLES).getText();

            if (title.toLowerCase().contains(searchTitleName.toLowerCase())) {
                foundIndex = i;
                foundFullTitleName = title;
                //extracting article name
                titles.add(element.findElement(ARTICLE_TITLES).getText());

                //extracting comment count
                if (element.findElements(ARTICLE_COUNTS).size() > 0) {
                    String countText = element.findElement(ARTICLE_COUNTS).getText(); //must be (101)
                    String count = countText.substring(countText.indexOf("(") + 1, countText.indexOf(")")); //must be 101
                    counts.add(Integer.valueOf(count)); //adding to List converting (str->to Int)
                } else
                    counts.add(0);

                //extracting from link href id=123123
                String hrefLink = element.findElement(ARTICLE_TITLES).getAttribute("href");
                //String id = hrefLink.substring(hrefLink.indexOf("id=")+3); //123123
                hrefIDs.add(hrefLink); //we cant use linkPart+id because link part is also different /sport/ or /news/ so we need full links
            }
        }

        //for (WebElement art : articleList) { System.out.println(art.getText() + " -index- " + articleList.indexOf(art)); }
        if (foundIndex >= 0) {
            System.out.println("F-U-L-L---Article search:<" + searchTitleName + "> =found with Index=<" + foundIndex + "> Full Title Name: <" + foundFullTitleName + ">");
            System.out.println(" ---title=" + titles.get(0) + " ---count=" + counts.get(0) + " ---href=" + hrefIDs.get(0));
        } else
            System.out.println("F-U-L-L---Article search:" + searchTitleName + " =found with Index=NO RESULT! :( -");


        Integer subCount = -1;
        if (foundIndex >= 0) {
            driver.get(hrefIDs.get(0));

            WebElement element = driver.findElement(SUB_ARTICLE);

            //extracting article name
            String subTitle = element.findElement(SUB_ARTICLE_TITLE).getText();

            //extracting comment count
            //Integer subCount;
            if (element.findElements(SUB_ARTICLE_COUNT).size() > 0) {
                String subCountText = element.findElement(SUB_ARTICLE_COUNT).getText();
                subCount = Integer.valueOf(subCountText.substring(subCountText.indexOf("(") + 1, subCountText.indexOf(")"))); //must be 101
            } else
                subCount = 0;
            //System.out.println(subTitle + " - " + subCount);
            Assert.assertEquals("Not Equal subArticle and Article Nr=" + foundIndex, titles.get(0), subTitle);
            Assert.assertEquals("Not Equal subCount   and Count   Nr=" + foundIndex, counts.get(0), subCount);

            //entering comment article (=3rd level) if exist comments
            if (subCount != 0) {
                String subHrefLink = element.findElement(SUB_ARTICLE_COUNT).getAttribute("href");
                driver.get(subHrefLink);

                WebElement regCountElement = driver.findElement(SUB2_REG_ARTICLE_COUNT);
                WebElement anonCountElement = driver.findElement(SUB2_ANON_ARTICLE_COUNT);

                String regCountText = regCountElement.findElement(By.xpath(".//span")).getText(); //(101)
                String anonCountText = anonCountElement.findElement(By.xpath(".//span")).getText(); //(101)

                Integer regCount = Integer.valueOf(regCountText.substring(regCountText.indexOf("(") + 1, regCountText.indexOf(")")));
                Integer anonCount = Integer.valueOf(anonCountText.substring(anonCountText.indexOf("(") + 1, anonCountText.indexOf(")")));
                Integer sum = regCount + anonCount;

                System.out.println(regCount + " = " + anonCount);
                Assert.assertEquals("Not Equal Count and Sub2_REG+ANON Nr=" + foundIndex, counts.get(0), sum);
            }
        }









        //2. M-O-B-I-L-E DELFI VERSION!
        WebDriverWait mobileWait = new WebDriverWait(mobileDriver, 6); // wait variable - if we will need to wait for element
        List<WebElement> mobArticleList = mobileDriver.findElements(MOB_ARTICLES); //List<WebElement> articleList = driver.findElements(By.xpath(".//*[@class='top2012-title']"));//xpath(".//class"));

        //will use List like a string -- taking 1st (0-index) == reason (for not to edit too much from previous written class) :)
        ArrayList<String> mobTitles = new ArrayList<String>();
        ArrayList<Integer> mobCounts = new ArrayList<Integer>(); //ArrayList<String> counts = new ArrayList<String>();
        ArrayList<String> mobHrefIDs = new ArrayList<String>();


        int mobFoundIndex = -1;
        String mobFoundFullTitleName = new String();
        boolean mobBreakLoop = false;

        //taking 5 first articles = Dima-boss ordered :) and extracting titleNameText, titleCommentCount, titleLinkHref and adding it to 3 lists
        //while (!breakLoop) //breakLoop = true; //if (i == articleList.size() - 1) breakLoop = true;

        for (int i = 0; i < mobArticleList.size(); i++) {
            WebElement element = mobArticleList.get(i);

            String mobTitle = element.findElement(MOB_ARTICLE_TITLES).getText();

            if (mobTitle.toLowerCase().contains(searchTitleName.toLowerCase())) {
                mobFoundIndex = i;
                mobFoundFullTitleName = mobTitle;
                //extracting article name
                mobTitles.add(element.findElement(MOB_ARTICLE_TITLES).getText());

                //extracting comment count
                if (element.findElements(MOB_ARTICLE_COUNTS).size() > 0) {
                    String mobCountText = element.findElement(MOB_ARTICLE_COUNTS).getText(); //must be (101)
                    String mobCount = mobCountText.substring(mobCountText.indexOf("(") + 1, mobCountText.indexOf(")")); //must be 101
                    mobCounts.add(Integer.valueOf(mobCount)); //adding to List converting (str->to Int)
                } else
                    mobCounts.add(0);

                //extracting from link href id=123123
                String mobHrefLink = element.findElement(MOB_ARTICLE_TITLES).getAttribute("href");
                //String id = hrefLink.substring(hrefLink.indexOf("id=")+3); //123123
                mobHrefIDs.add(mobHrefLink); //we cant use linkPart+id because link part is also different /sport/ or /news/ so we need full links
            }
        }

        //for (WebElement art : articleList) { System.out.println(art.getText() + " -index- " + articleList.indexOf(art)); }
        if (mobFoundIndex >= 0) {
            System.out.println("M-O-B-I-L-E---Article search:<" + searchTitleName + "> =found with Index=<" + mobFoundIndex + "> Full Title Name: <" + mobFoundFullTitleName + ">");
            System.out.println(" ---title=" + mobTitles.get(0) + " ---count=" + mobCounts.get(0) + " ---href=" + mobHrefIDs.get(0));
        } else
            System.out.println("M-O-B-I-L-E---Article search:" + searchTitleName + " =found with Index=NO RESULT! :( -");


        Integer mobSubCount = -1;
        if (mobFoundIndex >= 0) {
            mobileDriver.get(mobHrefIDs.get(0));

            WebElement element = mobileDriver.findElement(MOB_SUB_ARTICLE);

            //extracting article name
            String mobSubTitle = element.findElement(MOB_SUB_ARTICLE_TITLE).getText();

            //extracting comment count
            //Integer subCount;
            if (element.findElements(MOB_SUB_ARTICLE_COUNT).size() > 0) {
                String mobSubCountText = element.findElement(MOB_SUB_ARTICLE_COUNT).getText();
                mobSubCount = Integer.valueOf(mobSubCountText.substring(mobSubCountText.indexOf("(") + 1, mobSubCountText.indexOf(")"))); //must be 101
            } else
                mobSubCount = 0;
            System.out.println(mobSubTitle + " - " + mobSubCount);
            Assert.assertEquals("Not Equal subArticle and Article Nr=" + mobFoundIndex, mobTitles.get(0), mobSubTitle);
            Assert.assertEquals("Not Equal subCount   and Count   Nr=" + mobFoundIndex, mobCounts.get(0), mobSubCount);

            //entering comment article (=3rd level) if exist comments
            if (mobSubCount != 0) {
                String mobSubHrefLink = element.findElement(MOB_SUB_ARTICLE_COUNT).getAttribute("href");
                mobileDriver.get(mobSubHrefLink);

                WebElement mobRegCountElement = mobileDriver.findElement(MOB_SUB2_REG_ARTICLE_COUNT);
                WebElement mobAnonCountElement = mobileDriver.findElement(MOB_SUB2_ANON_ARTICLE_COUNT);

                String mobRegCountText = mobRegCountElement.findElement(By.xpath(".//span")).getText(); //(101)
                String mobAnonCountText = mobAnonCountElement.findElement(By.xpath(".//span")).getText(); //(101)

                Integer mobRegCount = Integer.valueOf(mobRegCountText.substring(mobRegCountText.indexOf("(") + 1, mobRegCountText.indexOf(")")));
                Integer mobAnonCount = Integer.valueOf(mobAnonCountText.substring(mobAnonCountText.indexOf("(") + 1, mobAnonCountText.indexOf(")")));
                Integer mobSum = mobRegCount + mobAnonCount;

                System.out.println(mobRegCount + " = " + mobAnonCount);
                Assert.assertEquals("Not Equal Count and MOB_Sub2_REG+ANON Nr=" + mobFoundIndex, mobCounts.get(0), mobSum);
            }
        }






        //3. Compare F-U-L-L and M-O-B-I-L-E  found title + count!
            Assert.assertEquals("Not Equal title Nr="+foundIndex + " and mobTitle MobNr="+mobFoundIndex,titles.get(0), mobTitles.get(0));//index(0)-because we have only 1 value of found Article (just using List like a string :) )
            Assert.assertEquals("Not Equal count Nr="+foundIndex + " and mobCount MobNr="+mobFoundIndex,counts.get(0), mobCounts.get(0));//index(0)-because we have only 1 value of found Article (just using List like a string :) )




        //Thread.sleep(1000);
        driver.quit();
        mobileDriver.quit();
        //ctrl-D or shift-shift or shift-alt=up or down
    }


}
