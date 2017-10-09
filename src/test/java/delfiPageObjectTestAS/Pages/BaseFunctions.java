package delfiPageObjectTestAS.Pages;

import delfiPageObjectTestAS.PageObjectTestAS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunctions {
    WebDriver driver;
    private String driverType = "webdriver.chrome.driver";
    private String driverLocation = "C:/chromedriver.exe";

    private static final Logger LOGGER = LogManager.getLogger(BaseFunctions.class);



    public BaseFunctions() { //CONSTRUCTOR!!
        LOGGER.info("Setting system properties");
        System.setProperty(driverType, driverLocation); //System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        LOGGER.info("Starting Chrome driver");
        this.driver = new ChromeDriver();

        LOGGER.info("Maximize browser window");
        driver.manage().window().maximize();
    }

    public void goToURL(String url) { //METHOD!!
        LOGGER.info("Open URL: " + url);
        driver.get(url);
    }

    public WebElement getElement(By locator) { //METHOD!!
        LOGGER.info("Getting element");
        return driver.findElement(locator);
    }

    public void clickElement(By locator) {
        LOGGER.info("Click title");
        driver.findElement(locator).click();
    }

    public void quitDriver() {
        LOGGER.info("Quit driver");
        driver.quit();
    }

}

