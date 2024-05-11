package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * open firefox
 * navigate to google home
 * search for "selenium webdriver"
 * check that text for the first search result is "WebDriver"
 * open the first search result
 * check that page header is "WebDriver"
 */
public class GoogleSearchStructuredTest {
    WebDriver driver;
    By firstSearchResult_Label = By.tagName("h3");

    @Test
    public void checkFirstSearchResultText() {
        String firstSearchResultText = driver.findElement(firstSearchResult_Label).getText();
        Assert.assertEquals(firstSearchResultText, "WebDriver");
    }

    @Test
    public void checkPageHeaderText() {
        driver.findElement(firstSearchResult_Label).click();
        By pageTitle_Label = By.tagName("h1");
        String pageTitleText = driver.findElement(pageTitle_Label).getText();
        Assert.assertEquals(pageTitleText, "WebDriver");
    }

    @BeforeMethod
    public void before() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        By search_Input = By.name("q");
        driver.findElement(search_Input).sendKeys("selenium webdriver", Keys.RETURN);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
