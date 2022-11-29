package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParametre {
    public  WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Robot robot;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void baslangicIslemleri(String browser) throws AWTException {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        if (browser.equalsIgnoreCase("chorome")){
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies(); }
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
        }else if (browser.equalsIgnoreCase("edge")){
            System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().deleteAllCookies();
        }


        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        robot = new Robot();

        driver.manage().window().setPosition(new Point(2000, 0));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Duration dr = Duration.ofSeconds(30);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

    }


}
