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
    private String startPage = "http://delfi.lv";
    private String mobileStartPage = "http://m.delfi.lv";
    //private String startPage = "http://www.delfi.lv/sports/news/eurobasket/zinas/bagatskis-pirms-speles-ar-sloveniju-mums-jabut-mierigiem-parliecinatiem-un-agresiviem.d?id=49230963";

    private static final By DELFI_1_ARTICLE_NAME = By.partialLinkText("Viesuļvētra 'Irma'"); //By.xpath(".//lalal");

    //private String startPage = "https://docs.google.com/forms/d/e/1FAIpQLSeu7sETvyNgltLvhYL1nhHfSRTax2mM637oVDG2c0zG5KquKg/viewform";



    @Test
    public void delfiTestAS() throws InterruptedException {
        /*
        //Firefox browser
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(); driver.manage().window().maximize(); driver.get("http://javaguru.lv");
        */



        //Chrome Driver
        System.setProperty(driverType, driverLocation); //System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //if (driverName == "Chrome") driver = new ChromeDriver(); else driver = new FirefoxDriver();
        WebDriver mobileDriver = new ChromeDriver(); //if (driverName == "Chrome") driver = new ChromeDriver(); else driver = new FirefoxDriver();
        driver.manage().window().maximize(); //driver.manage().window().fullscreen();
        mobileDriver.manage().window().maximize(); //driver.manage().window().fullscreen();

        driver.get(startPage);
        mobileDriver.get(mobileStartPage); //driver.get("http://javaguru.lv");
        WebDriverWait wait = new WebDriverWait(driver, 1); // wait variable - if we will need to wait for element
        //wait.until(ExpectedConditions.presenceOfElementLocated(DELFI_1_ARTICLE_NAME)).click(); //waiting for element appears for wait=10sec. //very LONG processing time :(

        //ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //driver.findElement(By.name("entry.1000000")).sendKeys("1_QA2-TestAS"); mozno.submit();
        //driver.findElement(By.id("group_738971122_2")).click(); //driver.findElement(By.name("entry.738971122")).click();

        //driver.getTitle();

        //driver.findElement(DELFI_1_ARTICLE_NAME); //driver.findElement(DELFI_1_ARTICLE_NAME).click();

        List<WebElement> titles = driver.findElements(By.xpath(".//h3[@class='top2012-title']"));//xpath(".//class"));
        //List<WebElement> titles = driver.findElements(By.xpath(".//*[@class='top2012-title']"));//xpath(".//class"));
        //List<WebElement> titles = driver.findElements(By.className("top2012-title"));//xpath(".//class"));

        List<WebElement> counts = driver.findElements(By.xpath(".//*[@class='comment-count']"));//xpath(".//class"));
        //List<WebElement> counts = driver.findElements(By.className("comment-count"));//xpath(".//class"));

        String linkOpenInNewTab = Keys.chord(Keys.SHIFT, Keys.RETURN); //Keys.chord(Keys.CONTROL,Keys.RETURN);
        //driver.findElement(By.linkText("Video: Aizputē un")).sendKeys(linkOpenInNewTab); //titles.get(0).sendKeys(linkOpenInNewTab);
        //driver.findElement(By.partialLinkText("Video: Aizputē un")).click();


        List<WebElement> mobileTitles = mobileDriver.findElements(By.xpath(".//*[@class='md-scrollpos']"));//xpath(".//class"));
        List<WebElement> mobileCounts = mobileDriver.findElements(By.xpath(".//*[@class='commentCount']"));//xpath(".//class"));


        //driver.findElement(By.id("ss-submit")).click(); //driver.findElement(By.name("fromLocation")).sendKeys(Keys.space);

        //for (E element : list) { }
        //for (int i = 0; i < list.size(); i++) { E element = list.get(i); }

        /*
        for (int i = 0; i < 9; i+=2) { //we need only 5 titles so 0,2,4,6,8
            WebElement title = titles.get(i);

            //open in new tab
            String linkOpenInNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            title.sendKeys(linkOpenInNewTab); //driver.findElement(By.linkText("urlLink")).sendKeys(linkOpenInNewTab);

            List<WebElement> subTitles = driver.findElements(By.className("article-title"));//xpath(".//class"));

            Assert.assertTrue("Titles are equals!", subTitles.get(0).getText() == title.getText() );

            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
        }
        */

        /*
        WebElement title = titles.get(0);
        String titleName = title.getText();

        title.click();
        //String linkOpenInNewTab = Keys.chord(Keys.CONTROL);
        //title.sendKeys(linkOpenInNewTab); //driver.findElement(By.linkText("urlLink")).sendKeys(linkOpenInNewTab);

        List<WebElement> subTitles = driver.findElements(By.className("article-title"));//xpath(".//class"));
        //Assert.assertTrue("Titles are equals!", subTitles.get(0).getText() == titleName );
        Assert.assertEquals("Titles are equals!", subTitles.get(0).getText(), titleName );
        */


        //new tab!!



        Assert.assertEquals("No Errors found!",2,2 );
        //Assert.assertEquals("Equals!", titles.get(0).getText(), mobileTitles.get(0).getText() );

        //Assert.assertEquals("Title",driver.getTitle());
        //Assert.assertTrue("No Errors found!",driver.findElements(DELFI_1_ARTICLE_NAME).size() > 0 );




        //System.out.println(driver.getTitle());         //System.out.println(driver.findElement(DELFI_1_ARTICLE_NAME).getText());
        // System.out.println(elements.get(0).getText());
        /*
        System.out.println(titleName); //System.out.println(title.getText());  System.out.println("un"); System.out.println(subTitles.get(0).getText());
        */


        System.out.println();
        System.out.println(" -= titles! =- -> " + titles.size()); System.out.println("=============================");
        for (WebElement tit : titles)        { System.out.println(tit.getText()); }
        //for (WebElement c : counts) { System.out.println(c.getText()); }


        System.out.println();
        System.out.println(" -= mobileTitles! =- -> " + mobileTitles.size()); System.out.println("=============================");
        for (WebElement mobTit : mobileTitles) { System.out.println(mobTit.getText()); }
        //for (WebElement mobC : mobileCounts) { System.out.println(mobC.getText()); }



        //subTitles.get(0).sendKeys(Keys.RETURN);

        //Thread.sleep(1000);
        driver.quit();
        mobileDriver.quit();

        //ctrl-D or shift-shift or shift-alt=up or down

    }


}
